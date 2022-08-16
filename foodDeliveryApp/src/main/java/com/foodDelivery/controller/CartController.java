package com.foodDelivery.controller;

import com.foodDelivery.entity.Cart;
import com.foodDelivery.entity.CartItemDTO1;
import com.foodDelivery.serviceLayer.Cart.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PutMapping(value = "/addItemToCart/{customerId}/{resturantId}/{itemId}")
    public ResponseEntity<Cart> addToCartHandler(@PathVariable ("customerId") Integer customerId, @PathVariable ("resturantId") Integer resturantId, @PathVariable ("itemId") Integer itemId){
        return new ResponseEntity<>(cartService.addItemToCart(customerId,resturantId,itemId), HttpStatus.OK);
    }

    @PutMapping (value = "/setQuantity/{itemDTOId}/{quantity}")
    public ResponseEntity<CartItemDTO1> setQuantityForEachItemDTOHandler (@PathVariable ("itemDTOId") Integer itemDTOId, @PathVariable ("quantity") Integer quantity){
        return new ResponseEntity<>(cartService.setQuantityForEachItemDTO(itemDTOId,quantity),HttpStatus.OK);
    }

    @PutMapping (value = "/increaseQuantity/{itemDTOId}/{quantity}")
    public ResponseEntity<CartItemDTO1> increaseQuantityForEachItemDTOHandler (@PathVariable ("itemDTOId") Integer itemDTOId, @PathVariable ("quantity") Integer quantity){
        return new ResponseEntity<>(cartService.increaseQuantityForEachItemDTO(itemDTOId,quantity),HttpStatus.OK);
    }

    @PutMapping (value = "/reduceQuantity/{itemDTOId}/{quantity}/cartId")
    public ResponseEntity<CartItemDTO1> reduceQuantityForEachItemDTOHandler (@PathVariable ("itemDTOId") Integer itemDTOId, @PathVariable ("quantity") Integer quantity, @PathVariable ("cartId") Integer cartId){
        return new ResponseEntity<>(cartService.reduceQuantityForEachItemDTO(cartId,itemDTOId,quantity),HttpStatus.OK);
    }

    @PutMapping (value = "/removeItemFromCart/{cartId}/{itemDTOId}")
    public ResponseEntity<CartItemDTO1> removeItemDTOFromCartHandler (@PathVariable ("cartId") Integer cartId, @PathVariable ("itemDTOId") Integer itemDTOId){
        return new ResponseEntity<>(cartService.removeItemDTOFromCart(cartId,itemDTOId),HttpStatus.OK);
    }

    @PutMapping (value = "clearCart/{cartId}")
    public ResponseEntity<Cart> clearCartHandler (@PathVariable ("cartId") Integer cartId){
        return new ResponseEntity<>(cartService.clearCart(cartId),HttpStatus.OK);
    }
}
