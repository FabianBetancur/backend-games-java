package org.webservice.api.domain.dto.db2;

import com.opencsv.bean.CsvBindByName;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CommentRequest {
    @NotBlank(message = "{NotBlank}")
    @CsvBindByName(column = "content",required = true)
    private String content;

    @NotNull(message = "{NotNull}")
    @CsvBindByName(column = "assetId",required = true)
    private Long assetId;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getAssetId() {
        return assetId;
    }

    public void setAssetId(Long assetId) {
        this.assetId = assetId;
    }
}
