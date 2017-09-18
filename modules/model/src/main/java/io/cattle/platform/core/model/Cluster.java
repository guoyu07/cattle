/*
 * This file is generated by jOOQ.
*/
package io.cattle.platform.core.model;


import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.3"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
@Entity
@Table(name = "cluster", schema = "cattle")
public interface Cluster extends Serializable {

    /**
     * Setter for <code>cattle.cluster.id</code>.
     */
    public void setId(Long value);

    /**
     * Getter for <code>cattle.cluster.id</code>.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false, precision = 19)
    public Long getId();

    /**
     * Setter for <code>cattle.cluster.name</code>.
     */
    public void setName(String value);

    /**
     * Getter for <code>cattle.cluster.name</code>.
     */
    @Column(name = "name", length = 255)
    public String getName();

    /**
     * Setter for <code>cattle.cluster.kind</code>.
     */
    public void setKind(String value);

    /**
     * Getter for <code>cattle.cluster.kind</code>.
     */
    @Column(name = "kind", nullable = false, length = 255)
    public String getKind();

    /**
     * Setter for <code>cattle.cluster.uuid</code>.
     */
    public void setUuid(String value);

    /**
     * Getter for <code>cattle.cluster.uuid</code>.
     */
    @Column(name = "uuid", unique = true, nullable = false, length = 128)
    public String getUuid();

    /**
     * Setter for <code>cattle.cluster.description</code>.
     */
    public void setDescription(String value);

    /**
     * Getter for <code>cattle.cluster.description</code>.
     */
    @Column(name = "description", length = 1024)
    public String getDescription();

    /**
     * Setter for <code>cattle.cluster.state</code>.
     */
    public void setState(String value);

    /**
     * Getter for <code>cattle.cluster.state</code>.
     */
    @Column(name = "state", nullable = false, length = 128)
    public String getState();

    /**
     * Setter for <code>cattle.cluster.created</code>.
     */
    public void setCreated(Date value);

    /**
     * Getter for <code>cattle.cluster.created</code>.
     */
    @Column(name = "created")
    public Date getCreated();

    /**
     * Setter for <code>cattle.cluster.removed</code>.
     */
    public void setRemoved(Date value);

    /**
     * Getter for <code>cattle.cluster.removed</code>.
     */
    @Column(name = "removed")
    public Date getRemoved();

    /**
     * Setter for <code>cattle.cluster.remove_time</code>.
     */
    public void setRemoveTime(Date value);

    /**
     * Getter for <code>cattle.cluster.remove_time</code>.
     */
    @Column(name = "remove_time")
    public Date getRemoveTime();

    /**
     * Setter for <code>cattle.cluster.data</code>.
     */
    public void setData(Map<String,Object> value);

    /**
     * Getter for <code>cattle.cluster.data</code>.
     */
    @Column(name = "data", length = 16777215)
    public Map<String,Object> getData();

    /**
     * Setter for <code>cattle.cluster.embedded</code>.
     */
    public void setEmbedded(Boolean value);

    /**
     * Getter for <code>cattle.cluster.embedded</code>.
     */
    @Column(name = "embedded", nullable = false, precision = 1)
    public Boolean getEmbedded();

    /**
     * Setter for <code>cattle.cluster.creator_id</code>.
     */
    public void setCreatorId(Long value);

    /**
     * Getter for <code>cattle.cluster.creator_id</code>.
     */
    @Column(name = "creator_id", precision = 19)
    public Long getCreatorId();

    /**
     * Setter for <code>cattle.cluster.default_network_id</code>.
     */
    public void setDefaultNetworkId(Long value);

    /**
     * Getter for <code>cattle.cluster.default_network_id</code>.
     */
    @Column(name = "default_network_id", precision = 19)
    public Long getDefaultNetworkId();

    /**
     * Setter for <code>cattle.cluster.external_id</code>.
     */
    public void setExternalId(String value);

    /**
     * Getter for <code>cattle.cluster.external_id</code>.
     */
    @Column(name = "external_id", length = 255)
    public String getExternalId();

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    /**
     * Load data from another generated Record/POJO implementing the common interface Cluster
     */
    public void from(io.cattle.platform.core.model.Cluster from);

    /**
     * Copy data into another generated Record/POJO implementing the common interface Cluster
     */
    public <E extends io.cattle.platform.core.model.Cluster> E into(E into);
}