package org.webservice.api.domain.coredb2;

import lombok.Data;

@Data
public class BrandsDto {
    private Long brandId;
    private String description;

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
