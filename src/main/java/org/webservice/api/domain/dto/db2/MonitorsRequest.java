package org.webservice.api.domain.dto.db2;

import com.opencsv.bean.CsvBindByName;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MonitorsRequest {
    @NotBlank(message = "{NotBlank}")
    @CsvBindByName(column = "serialNumber",required = true)
    private String serialNumber;

    @NotNull(message = "{NotNull}")
    @CsvBindByName(column = "brandId",required = true)
    private Long brandId;

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }
}
