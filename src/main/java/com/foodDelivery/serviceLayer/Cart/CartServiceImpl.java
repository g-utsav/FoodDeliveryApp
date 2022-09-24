package com.foodDelivery.serviceLayer.Cart;

import com.foodDelivery.dataAcessLayer.*;
import com.foodDelivery.entity.*;
import com.foodDelivery.exceptions.CartItemNotFoundException;
import com.foodDelivery.exceptions.CartItemQuantityException;
import com.foodDelivery.exceptions.CartNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.foodDelivery.entity.CartItemDTO1;
import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService{

    @Autowired
    private CartItemDTODao cartItemDTODao;

    @Autowired
    private CartItemDao cartItemDao;

    @Autowired
    private RestaurantDao restaurantDao;

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private CartDao cartDao;

    @Override
    public Cart addItemToCart(Integer customerId,Integer resturantId, Integer itemId) {
        Cart cart=null;
        Optional<Customer> opt = customerDao.findById(customerId);

        if (opt.isPresent()){

            Customer customer = opt.get();
            cart = customer.getCart();
            Optional<Item> itemOpt = cartItemDao.findById(itemId);

            if (itemOpt.isPresent()){

                Item item = itemOpt.get();
                Optional<Restaurant> restaurantOpt = restaurantDao.findById(resturantId);

                if (restaurantOpt.isPresent()){
                    Restaurant restaurant = restaurantOpt.get();

                    List<CartItemDTO1> cartItems = cart.getCartItems();

                    CartItemDTO1 itemDTO = new CartItemDTO1();

                    itemDTO.setItemId(item.getItemId());
                    itemDTO.setRestaurantId(restaurant.getResturantId());
                    itemDTO.setItemName(item.getItemName());
                    itemDTO.setCategoryName( item.getCategory().getCategoryName());
                    itemDTO.setResturantName(restaurant.getRestaurantName());
                    itemDTO.setQuantity(1);
                    itemDTO.setCost(item.getCost());
                    //itemDTO.setCart(cart);
                    itemDTO.setCartId(cart.getCartId());

                    cartItems.add(itemDTO);
                    cartItemDTODao.save(itemDTO);
                }
                else{
                    //Exception
                }
            }
            else{
                //Exception
            }
        }else{
            //Exception
        }

        return cart;
    }

    @Override
    public CartItemDTO1 setQuantityForEachItemDTO(Integer itemDTOId, Integer quantity) {
        CartItemDTO1 itemDTO = null;
        Optional<CartItemDTO1> opt = cartItemDTODao.findById(itemDTOId);

        if (opt.isPresent()){
            itemDTO = opt.get();
            itemDTO.setQuantity(quantity);
            cartItemDTODao.save(itemDTO);
        }
        else {
            //Exception
        }
        return itemDTO;
    }

    @Override
    public CartItemDTO1 increaseQuantityForEachItemDTO(Integer itemDTOId, Integer quantity) {

        CartItemDTO1 itemDTO =null;
        Optional<CartItemDTO1> itemDTOopt = cartItemDTODao.findById(itemDTOId);

        if (itemDTOopt.isPresent()){
            itemDTO = itemDTOopt.get();

            itemDTO.setQuantity(itemDTO.getQuantity()+quantity);
            cartItemDTODao.save(itemDTO);
        }
        else {
            //Exception
        }

        return itemDTO;
    }


    @Override
    public CartItemDTO1 reduceQuantityForEachItemDTO(Integer cartId, Integer itemDTOId, Integer quantity) throws CartNotFoundException, CartItemNotFoundException, CartItemQuantityException {

        Cart cart=null;
        CartItemDTO1 itemDTO = null;

        Optional<Cart> cartOpt = cartDao.findById(cartId);

        if (cartOpt.isPresent()){

            cart=cartOpt.get();


            Optional<CartItemDTO1> opt = cartItemDTODao.findById(itemDTOId);

            if (opt.isPresent()){
                itemDTO = opt.get();

                if (itemDTO.getQuantity()>quantity){
                    if (itemDTO.getQuantity()-quantity==0){
                        //remove item from cartitems and from itemdto database
                        cart.getCartItems().remove(itemDTO);
                        cartItemDTODao.deleteItemDTOByCartId(cartId);
                    }
                    else{
                        itemDTO.setQuantity(itemDTO.getQuantity()-quantity);
                        cartItemDTODao.save(itemDTO);
                    }
                }
                else{
                    //Exception
                    throw new CartItemQuantityException("Quantity to be Reduced should be lesser than Actual Quantity");
                }
            }
            else {
                //Exception
                throw new CartItemNotFoundException("Cart Item Not Found");
            }
        }
        else{
            //Exception
            throw new CartNotFoundException("Cart Not Found");
        }

        return itemDTO;
    }

    @Override
    public CartItemDTO1 removeItemDTOFromCart(Integer cartId, Integer itemDTOId) throws CartItemNotFoundException, CartNotFoundException {
        CartItemDTO1 itemDTO =null;

        Optional<Cart> cartOpt = cartDao.findById(cartId);

        if (cartOpt.isPresent()){
            Cart cart = cartOpt.get();

            Optional<CartItemDTO1> itemDTOOpt = cartItemDTODao.findById(itemDTOId);

            if (itemDTOOpt.isPresent()){
                itemDTO =itemDTOOpt.get();

                cart.getCartItems().remove(itemDTO);
                cartItemDTODao.delete(itemDTO);
            }
            else{
                //Exception
                throw new CartItemNotFoundException("Cart Item Not Found");
            }
        }
        else{
            //Exception
            throw new CartNotFoundException("Cart Not Found");
        }
        return itemDTO;
    }

    @Override
    public Cart clearCart(Integer cartId) {
        Cart cart=null;
        Optional<Cart> cartOpt = cartDao.findById(cartId);

        if (cartOpt.isPresent()){
            cart=cartOpt.get();
            //cart.getCartItems().removeAll(cart.getCartItems());
            cart.setCartItems(null);

            List<CartItemDTO1> cartItemDTO1List = cart.getCartItems();

            cartItemDTODao.deleteAll(cartItemDTO1List);

            //cartItemDTODao.deleteItemDTOByCartId(cartId);
        }
        else{
            //Exception
        }
        return cart;
    }
}
