package org.webservice.api.domain.coredb2;

import lombok.Data;

@Data
public class AssetsDto {
    private Long assetId;
    private Long uniqueId;
    private String serialHostname;
    private Long modelId;
    private Long typeId;
    private Long brandId;
    private String hostName;
/*
    private UsersAsset usersAsset;
    private Model model;
    private Type type;
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
