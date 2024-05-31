package com.example.demo.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class ShoppingCartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne // Relacion con ShoppingCart
    private ShoppingCart cartId;

    @ManyToOne // Relación con Producto
    private Producto productItem;

    private int quantity;

    public ShoppingCartItem() {}

    public ShoppingCartItem(ShoppingCart cartId, Producto productItem, int quantity) {
        this.cartId = cartId;
        this.productItem = productItem;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ShoppingCart getCartId() {
        return cartId;
    }

    public void setCartId(ShoppingCart cartId) {
        this.cartId = cartId;
    }

    public Producto getProductItemId() {
        return productItem;
    }

    public void setProductItemId(Producto productItem) {
        this.productItem = productItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
