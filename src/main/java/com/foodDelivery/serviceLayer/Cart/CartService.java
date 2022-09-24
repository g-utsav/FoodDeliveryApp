package com.foodDelivery.serviceLayer.Cart;

import com.foodDelivery.entity.Cart;
import com.foodDelivery.entity.CartItemDTO1;
import com.foodDelivery.exceptions.CartItemNotFoundException;
import com.foodDelivery.exceptions.CartItemQuantityException;
import com.foodDelivery.exceptions.CartNotFoundException;

public interface CartService {
    public Cart addItemToCart(Integer customerId, Integer resturantId, Integer itemId);
    public CartItemDTO1 setQuantityForEachItemDTO(Integer itemDTOId, Integer quantity);
    public CartItemDTO1 increaseQuantityForEachItemDTO(Integer itemDTOId, Integer quantity);
    public CartItemDTO1 reduceQuantityForEachItemDTO(Integer cartId, Integer itemDTOId, Integer quantity) throws CartNotFoundException, CartItemNotFoundException, CartItemQuantityException;
    public CartItemDTO1 removeItemDTOFromCart(Integer cartId, Integer itemDTOId) throws CartItemNotFoundException, CartNotFoundException;
    public Cart clearCart(Integer cartId);
}
