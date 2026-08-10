package org.webservice.api.domain.coredb2;

import lombok.Data;

@Data
public class AssetsViewDto {
    private Long id;
    private String brand;
    private String model;
    private String type;
    private String serialNumber;
    private String hostName;
    private Long uid;
    private String assignedUser;
    private String employeeId;
    private String state;

    public void setId(Long id) {
        this.id = id;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public void setAssignedUser(String assignedUser) {
        this.assignedUser = assignedUser;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public void setState(String state) {
        this.state = state;
    }
}
