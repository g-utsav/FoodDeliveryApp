package com.foodDelivery.serviceLayer.Cart;

import com.foodDelivery.entity.Cart;
import com.foodDelivery.entity.CartItemDTO1;

public interface CartService {
    public Cart addItemToCart(Integer customerId, Integer resturantId, Integer itemId);
    public CartItemDTO1 setQuantityForEachItemDTO(Integer itemDTOId, Integer quantity);
    public CartItemDTO1 increaseQuantityForEachItemDTO(Integer itemDTOId, Integer quantity);
    public CartItemDTO1 reduceQuantityForEachItemDTO(Integer cartId, Integer itemDTOId, Integer quantity);
    public CartItemDTO1 removeItemDTOFromCart(Integer cartId, Integer itemDTOId);
    public Cart clearCart(Integer cartId);
}
