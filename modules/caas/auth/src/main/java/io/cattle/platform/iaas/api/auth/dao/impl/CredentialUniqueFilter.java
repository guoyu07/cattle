package io.cattle.platform.iaas.api.auth.dao.impl;

import io.cattle.platform.core.constants.CredentialConstants;
import io.cattle.platform.core.model.Credential;
import io.cattle.platform.framework.encryption.EncryptionConstants;
import io.cattle.platform.iaas.api.auth.dao.PasswordDao;
import io.cattle.platform.iaas.api.auth.integration.local.LocalAuthPasswordValidator;
import io.cattle.platform.json.JsonMapper;
import io.github.ibuildthecloud.gdapi.context.ApiContext;
import io.github.ibuildthecloud.gdapi.exception.ValidationErrorException;
import io.github.ibuildthecloud.gdapi.factory.SchemaFactory;
import io.github.ibuildthecloud.gdapi.request.ApiRequest;
import io.github.ibuildthecloud.gdapi.request.resource.AbstractValidationFilter;
import io.github.ibuildthecloud.gdapi.request.resource.ResourceManager;
import io.github.ibuildthecloud.gdapi.validation.ValidationErrorCodes;

import org.apache.commons.lang3.StringUtils;

public class CredentialUniqueFilter extends AbstractValidationFilter {

    SchemaFactory schemaFactory;
    PasswordDao passwordDao;
    JsonMapper jsonMapper;

    public CredentialUniqueFilter(SchemaFactory schemaFactory, PasswordDao passwordDao, JsonMapper jsonMapper) {
        super();
        this.schemaFactory = schemaFactory;
        this.passwordDao = passwordDao;
        this.jsonMapper = jsonMapper;
    }

    @Override
    public Object create(String type, ApiRequest request, ResourceManager next) {
        Credential credential = request.proxyRequestObject(Credential.class);
        if (StringUtils.isBlank(credential.getKind())) {
            credential.setKind(request.getType());
        }
        if (StringUtils.equals(credential.getKind(), CredentialConstants.KIND_PASSWORD)) {
            LocalAuthPasswordValidator.validatePassword(credential.getSecretValue(), jsonMapper);
            String clearSecret = credential.getSecretValue();
            credential.setSecretValue(ApiContext.getContext().getTransformationService().transform(clearSecret, EncryptionConstants.PASSWORD));

            boolean isUnique = passwordDao.isUnique(credential);
            if (!isUnique) {
                throw new ValidationErrorException(ValidationErrorCodes.NOT_UNIQUE, CredentialConstants.PUBLIC_VALUE);
            }
            credential = (Credential) super.create(type, request, next);
            credential.setSecretValue(clearSecret);
            return credential;
        }

        boolean isUnique = passwordDao.isUnique(credential);
        if (!isUnique) {
            throw new ValidationErrorException(ValidationErrorCodes.NOT_UNIQUE, CredentialConstants.PUBLIC_VALUE);
        }

        return super.create(type, request, next);
    }

}
