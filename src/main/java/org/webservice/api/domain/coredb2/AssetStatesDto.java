package org.webservice.api.domain.coredb2;


import lombok.Data;

@Data
public class AssetStatesDto {
    private Long stateId;
    private String description;

    public Long getStateId() {
        return stateId;
    }

    public void setStateId(Long stateId) {
        this.stateId = stateId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
