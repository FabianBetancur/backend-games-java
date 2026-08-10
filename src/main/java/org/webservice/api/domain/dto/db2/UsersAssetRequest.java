package org.webservice.api.domain.dto.db2;

import com.opencsv.bean.CsvBindByName;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UsersAssetRequest {
    @NotBlank(message = "{NotBlank}")
    @CsvBindByName(column = "name",required = true)
    private String name;

    @NotBlank(message = "{eid.required}")
    @CsvBindByName(column = "employeeId",required = true)
    private String employeeId;

    @NotNull(message = "{NotNull}")
    @CsvBindByName(column = "areaId",required = true)
    private Long areaId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }
}
