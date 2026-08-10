package org.webservice.api.domain.coredb2;

import com.opencsv.bean.CsvBindByName;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AreasDto {
    private Long areaId;

    @NotBlank(message = "{NotBlank}")
    @CsvBindByName(column = "description",required = true)
    private String description;

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
