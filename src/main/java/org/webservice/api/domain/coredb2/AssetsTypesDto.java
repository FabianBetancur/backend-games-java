package org.webservice.api.domain.coredb2;

import lombok.Data;

@Data
public class AssetsTypesDto {
    private Long typeId;
    private String description;

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
