package org.webservice.api.domain.dto;

import lombok.Data;

@Data
public class UrlRequest {
    private String url;
    private Long userId;

    public UrlRequest() {}

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
