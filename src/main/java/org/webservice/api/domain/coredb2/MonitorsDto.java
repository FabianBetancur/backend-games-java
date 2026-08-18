package org.webservice.api.domain.coredb2;

import lombok.Data;

@Data
public class MonitorsDto {
    private Long monitorId;
    private String serialNumber;
    private Long brandId;
    private BrandsDto brand;

    public Long getMonitorId() {
        return monitorId;
    }

    public void setMonitorId(Long monitorId) {
        this.monitorId = monitorId;
    }

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

    public BrandsDto getBrand() {
        return brand;
    }

    public void setBrand(BrandsDto brand) {
        this.brand = brand;
    }
}
