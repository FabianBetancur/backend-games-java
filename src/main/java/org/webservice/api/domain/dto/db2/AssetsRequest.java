package org.webservice.api.domain.dto.db2;

import com.opencsv.bean.CsvBindByName;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AssetsRequest {
    @NotBlank(message = "{uid.required}")
    @CsvBindByName(column = "uniqueId",required = true)
    private String uniqueId;

    @NotNull(message = "{NotNull}")
    @CsvBindByName(column = "assignedUserId",required = true)
    private Long assignedUserId;

    @NotBlank(message = "{NotBlank}")
    @CsvBindByName(column = "serialNumber",required = true)
    private String serialNumber;

    @NotNull(message = "{NotNull}")
    @CsvBindByName(column = "modelId",required = true)
    private Long modelId;

    @NotNull(message = "{NotNull}")
    @CsvBindByName(column = "typeId",required = true)
    private Long typeId;

    @NotNull(message = "{NotNull}")
    @CsvBindByName(column = "brandId",required = true)
    private Long brandId;

    @NotBlank(message = "{NotBlank}")
    @CsvBindByName(column = "hostName",required = true)
    private String hostName;

    @NotNull(message = "{NotNull}")
    @CsvBindByName(column = "stateId",required = true)
    private Long stateId;

    @NotNull(message = "{NotNull}")
    @CsvBindByName(column = "monitorId",required = true)
    private Long monitorId;

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public Long getAssignedUserId() {
        return assignedUserId;
    }

    public void setAssignedUserId(Long assignedUserId) {
        this.assignedUserId = assignedUserId;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Long getModelId() {
        return modelId;
    }

    public void setModelId(Long modelId) {
        this.modelId = modelId;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public Long getStateId() {
        return stateId;
    }

    public void setStateId(Long stateId) {
        this.stateId = stateId;
    }

    public Long getMonitorId() {
        return monitorId;
    }

    public void setMonitorId(Long monitorId) {
        this.monitorId = monitorId;
    }
}
