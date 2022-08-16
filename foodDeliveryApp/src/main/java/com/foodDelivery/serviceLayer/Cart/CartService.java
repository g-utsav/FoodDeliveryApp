package com.foodDelivery.serviceLayer.Cart;

import com.foodDelivery.entity.Cart;
import com.foodDelivery.entity.ItemDTO;

public interface CartService {
    public Cart addItemToCart(Integer customerId, Integer resturantId, Integer itemId);
    public ItemDTO setQuantityForEachItemDTO(Integer itemDTOId, Integer quantity);
    public ItemDTO increaseQuantityForEachItemDTO(Integer itemDTOId, Integer quantity);
    public ItemDTO reduceQuantityForEachItemDTO(Integer cartId, Integer itemDTOId, Integer quantity);
    public ItemDTO removeItemDTOFromCart(Integer cartId, Integer itemDTOId);
    public Cart clearCart(Integer cartId);
}
