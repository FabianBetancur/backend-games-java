package org.webservice.api.domain.core;

import java.time.LocalDateTime;

public class CartItemsDto {
    private Long id;
    private Long cartId;
    private ShoppingCartsDto cart;
    private Long gameId;
    private GamesViewDto game;
    private Integer quantity;
    private LocalDateTime addedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getAddedAt() {
        return addedAt;
    }

    public void setAddedAt(LocalDateTime addedAt) {
        this.addedAt = addedAt;
    }

    public ShoppingCartsDto getCart() {
        return cart;
    }

    public void setCart(ShoppingCartsDto cart) {
        this.cart = cart;
    }

    public GamesViewDto getGame() {
        return game;
    }

    public void setGame(GamesViewDto game) {
        this.game = game;
    }
}
