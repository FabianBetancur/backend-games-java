package org.webservice.api.domain.core;

//import org.webservice.api.persistence.entity.Users;

import java.time.LocalDateTime;

public class ShoppingCartsDto {
    private Long cartId;
    private Long userId;
    private LocalDateTime createdAt;
    private String status;
    //private Users user;

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    /*
    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

     */
}
