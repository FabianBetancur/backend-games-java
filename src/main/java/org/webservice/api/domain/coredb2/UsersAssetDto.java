package org.webservice.api.domain.coredb2;

import lombok.Data;

@Data
public class UsersAssetDto {
    private Long userId;
    private String name;
    private String employeeId;
    private Long areaId;
    private AreasDto area;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

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

    public AreasDto getArea() {
        return area;
    }

    public void setArea(AreasDto area) {
        this.area = area;
    }
}
