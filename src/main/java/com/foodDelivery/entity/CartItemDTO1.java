package com.foodDelivery.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class CartItemDTO1 {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer itemDTOId;

    //@NotNull
    Integer restaurantId;

    //@NotNull
    Integer itemId;

    @NotNull
    String itemName;

    //@NotNull
    String categoryName;

    //@NotNull
    String resturantName;

    @NotNull
    Double cost;

    @Min(1)
    Integer quantity;

    /*@ManyToOne (cascade = CascadeType.ALL)
    private Cart cart;*/

    @NotNull
    private Integer cartId;

    public CartItemDTO1() {
    }

    public CartItemDTO1(Integer itemDTOId, Integer restaurantId, Integer itemId, String itemName, String categoryName, String resturantName, Double cost, Integer quantity, Integer cartId) {
        this.itemDTOId = itemDTOId;
        this.restaurantId = restaurantId;
        this.itemId = itemId;
        this.itemName = itemName;
        this.categoryName = categoryName;
        this.resturantName = resturantName;
        this.cost = cost;
        this.quantity = quantity;
        this.cartId = cartId;
    }

    public Integer getItemDTOId() {
        return itemDTOId;
    }

    public void setItemDTOId(Integer itemDTOId) {
        this.itemDTOId = itemDTOId;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getResturantName() {
        return resturantName;
    }

    public void setResturantName(String resturantName) {
        this.resturantName = resturantName;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    @Override
    public String toString() {
        return "CartItemDTO1{" +
                "itemDTOId=" + itemDTOId +
                ", restaurantId=" + restaurantId +
                ", itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", resturantName='" + resturantName + '\'' +
                ", cost=" + cost +
                ", quantity=" + quantity +
                ", cartId=" + cartId +
                '}';
    }
}
