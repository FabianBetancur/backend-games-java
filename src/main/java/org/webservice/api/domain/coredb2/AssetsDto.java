package org.webservice.api.domain.coredb2;

import lombok.Data;

@Data
public class AssetsDto {
    private Long assetId;
    private Long uniqueId;
    private Long assignedUserId;
    private String serialHostname;
    private Long modelId;
    private Long typeId;
    private Long brandId;
    private String hostName;
    private Long stateId;
    private UsersAssetDto usersAsset;
    private ModelsDto model;
    private AssetsTypesDto assetsType;
    private BrandsDto brand;
    private AssetStatesDto state;


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

    public UsersAssetDto getUsersAsset() {
        return usersAsset;
    }

    public void setUsersAsset(UsersAssetDto usersAsset) {
        this.usersAsset = usersAsset;
    }

    public ModelsDto getModel() {
        return model;
    }

    public void setModel(ModelsDto model) {
        this.model = model;
    }

    public AssetsTypesDto getAssetsType() {
        return assetsType;
    }

    public void setAssetsType(AssetsTypesDto assetsType) {
        this.assetsType = assetsType;
    }

    public BrandsDto getBrand() {
        return brand;
    }

    public void setBrand(BrandsDto brand) {
        this.brand = brand;
    }

    public Long getStateId() {
        return stateId;
    }

    public void setStateId(Long stateId) {
        this.stateId = stateId;
    }

    public AssetStatesDto getState() {
        return state;
    }

    public void setState(AssetStatesDto state) {
        this.state = state;
    }
}
