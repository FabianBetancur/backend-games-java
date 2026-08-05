package org.webservice.api.domain.coredb2;

import lombok.Data;

@Data
public class AreasDto {
    private Long assetId;
    private String description;

    public Long getAssetId() {
        return assetId;
    }

    public void setAssetId(Long assetId) {
        this.assetId = assetId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
