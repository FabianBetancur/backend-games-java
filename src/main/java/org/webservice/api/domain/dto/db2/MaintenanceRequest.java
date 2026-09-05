package org.webservice.api.domain.dto.db2;

import com.opencsv.bean.CsvBindByName;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MaintenanceRequest {
    @NotBlank(message = "{NotBlank}")
    @CsvBindByName(column = "comment",required = true)
    private String comment;

    @NotNull(message = "{NotNull}")
    @CsvBindByName(column = "assetId",required = true)
    private Long assetId;


    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getAssetId() {
        return assetId;
    }

    public void setAssetId(Long assetId) {
        this.assetId = assetId;
    }
}
