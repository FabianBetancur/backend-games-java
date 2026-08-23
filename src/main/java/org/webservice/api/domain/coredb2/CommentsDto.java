package org.webservice.api.domain.coredb2;


import com.opencsv.bean.CsvBindByName;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommentsDto {
    private Long commentId;
    private String content;
    private LocalDateTime createdAt;
    private Long assetId;
    private AssetsDto asset;

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Long getAssetId() {
        return assetId;
    }

    public void setAssetId(Long assetId) {
        this.assetId = assetId;
    }

    public AssetsDto getAsset() {
        return asset;
    }

    public void setAsset(AssetsDto asset) {
        this.asset = asset;
    }
}
