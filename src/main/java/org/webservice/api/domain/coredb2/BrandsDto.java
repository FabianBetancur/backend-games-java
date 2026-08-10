package org.webservice.api.domain.coredb2;

import com.opencsv.bean.CsvBindByName;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class BrandsDto {
    private Long brandId;

    @NotBlank(message = "{NotBlank}")
    @CsvBindByName(column = "description",required = true)
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
