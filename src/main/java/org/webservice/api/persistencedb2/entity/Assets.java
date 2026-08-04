package org.webservice.api.persistencedb2.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "assets")
public class Assets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "asset_id")
    private Long assetId;

    @Column(name = "unique_id",nullable = false)
    private Long uniqueId;

    @Column(name = "assigned_user_id", nullable = false)
    private Long assignedUserId;

    @Column(name = "serial_number", nullable = false)
    private String serialHostname;

    @Column(name = "model_id", nullable = false)
    private Long modelId;

    @Column(name = "type_id", nullable = false)
    private Long typeId;

    @Column(name = "brand_id", nullable = false)
    private Long brandId;

    @Column(name = "host_name", nullable = false)
    private String hostName;

    /*
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "assigned_user_id", insertable = false, updatable = false)
    private UsersAsset usersAsset;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "model_id", insertable = false, updatable = false)
    private Model model;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "type_id", insertable = false, updatable = false)
    private Type type;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "brand_id", insertable = false, updatable = false)
    private Brand brand;

     */

    public Long getAssetId() {
        return assetId;
    }

    public void setAssetId(Long assetId) {
        this.assetId = assetId;
    }

    public Long getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(Long uniqueId) {
        this.uniqueId = uniqueId;
    }

    public Long getAssignedUserId() {
        return assignedUserId;
    }

    public void setAssignedUserId(Long assignedUserId) {
        this.assignedUserId = assignedUserId;
    }

    public String getSerialHostname() {
        return serialHostname;
    }

    public void setSerialHostname(String serialHostname) {
        this.serialHostname = serialHostname;
    }

    public Long getModelId() {
        return modelId;
    }

    public void setModelId(Long modelId) {
        this.modelId = modelId;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }
}
