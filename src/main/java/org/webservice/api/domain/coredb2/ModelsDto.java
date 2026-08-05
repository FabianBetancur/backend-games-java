package org.webservice.api.domain.coredb2;

import lombok.Data;

@Data
public class ModelsDto {
    private Long modelId;
    private String description;

    public Long getModelId() {
        return modelId;
    }

    public void setModelId(Long modelId) {
        this.modelId = modelId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
