package org.webservice.api.domain.coredb2;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MaintenancesDto {
    private Long maintenanceId;
    private String comment;
    private LocalDateTime registerDate;
    private Long assetId;
    private AssetsDto asset;

    public Long getMaintenanceId() {
        return maintenanceId;
    }

    public void setMaintenanceId(Long maintenanceId) {
        this.maintenanceId = maintenanceId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDateTime registerDate) {
        this.registerDate = registerDate;
    }

    public Long getAssetId() {
        return assetId;
    }

    public void setAssetId(Long assetId) {
        this.assetId = assetId;
    }

    public AssetsDto getAsset() {
        return asset;
    }

    public void setAsset(AssetsDto asset) {
        this.asset = asset;
    }
}
