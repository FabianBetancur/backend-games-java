package org.webservice.api.persistence.entity.core;

import jakarta.persistence.*;
import org.hibernate.annotations.DynamicInsert;

import java.time.LocalDateTime;

@Entity
@DynamicInsert
@Table(name = "cart_items")
public class CartItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_item_id")
    private Long id;

    @Column(name = "cart_id")
    private Long cartId;

    @Column(name = "game_id")
    private Long gameId;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "added_at")
    private LocalDateTime addedAt;

    @ManyToOne
    @JoinColumn(name = "cart_id",insertable = false,updatable = false)
    private ShoppingCarts cart;

    @ManyToOne
    @JoinColumn(name = "game_id", insertable = false,updatable = false)
    private GamesView game;

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

    public ShoppingCarts getCart() {
        return cart;
    }

    public void setCart(ShoppingCarts cart) {
        this.cart = cart;
    }

    public GamesView getGame() {
        return game;
    }

    public void setGame(GamesView game) {
        this.game = game;
    }
}
