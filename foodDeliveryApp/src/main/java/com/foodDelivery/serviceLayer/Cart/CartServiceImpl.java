package com.foodDelivery.serviceLayer.Cart;

import com.foodDelivery.dataAcessLayer.*;
import com.foodDelivery.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.foodDelivery.entity.ItemDTO;
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
        Optional<Cart> opt = cartDao.findById(customerId);

        if (opt.isPresent()){

            Cart cart = opt.get();
            Optional<Item> itemOpt = cartItemDao.findById(itemId);

            if (itemOpt.isPresent()){

                Item item = itemOpt.get();
                Optional<Restaurant> restaurantOpt = restaurantDao.findById(resturantId);


                if (restaurantOpt.isPresent()){
                    Restaurant restaurant = restaurantOpt.get();

                    List<ItemDTO> cartItems = cart.getCartItems();

                    ItemDTO itemDTO = new ItemDTO();
                    itemDTO.setItemId(item.getItemId());
                    itemDTO.setRestaurantId(restaurant.getResturantId());
                    itemDTO.setItemName(item.getItemName());
                    itemDTO.setCategoryName( item.getCategory().getCategoryName());
                    itemDTO.setResturantName(restaurant.getRestaurantName());
                    itemDTO.setQuantity(1);
                    itemDTO.setCost(item.getCost());

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

        return opt.get();
    }

    @Override
    public ItemDTO setQuantityForEachItemDTO(Integer itemDTOId, Integer quantity) {
        ItemDTO itemDTO = null;
        Optional<ItemDTO> opt = cartItemDTODao.findById(itemDTOId);

        if (opt.isPresent()){
            itemDTO = opt.get();
            itemDTO.setQuantity(quantity);
        }
        else {
            //Exception
        }
        return itemDTO;
    }

    @Override
    public ItemDTO increaseQuantityForEachItemDTO(Integer itemDTOId, Integer quantity) {

        ItemDTO itemDTO =null;
        Optional<ItemDTO> itemDTOopt = cartItemDTODao.findById(itemDTOId);

        if (itemDTOopt.isPresent()){
            itemDTO = itemDTOopt.get();

            itemDTO.setQuantity(itemDTO.getQuantity()+quantity);
        }
        else {
            //Exception
        }

        return itemDTO;
    }


    @Override
    public ItemDTO reduceQuantityForEachItemDTO(Integer cartId, Integer itemDTOId, Integer quantity) {

        Cart cart=null;
        ItemDTO itemDTO = null;

        Optional<Cart> cartOpt = cartDao.findById(cartId);

        if (cartOpt.isPresent()){

            cart=cartOpt.get();


            Optional<ItemDTO> opt = cartItemDTODao.findById(itemDTOId);

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
                    }
                }
                else{
                    //Exception
                }
            }
            else {
                //Exception
            }
        }
        else{
            //Exception
        }

        return itemDTO;
    }

    @Override
    public ItemDTO removeItemDTOFromCart(Integer cartId, Integer itemDTOId) {
        ItemDTO itemDTO =null;

        Optional<Cart> cartOpt = cartDao.findById(cartId);

        if (cartOpt.isPresent()){
            Cart cart = cartOpt.get();

            Optional<ItemDTO> itemDTOOpt = cartItemDTODao.findById(itemDTOId);

            if (itemDTOOpt.isPresent()){
                itemDTO =itemDTOOpt.get();
                cart.getCartItems().remove(itemDTO);
                cartItemDTODao.delete(itemDTO);
            }
            else{
                //Exception
            }
        }
        else{
            //Exception
        }
        return itemDTO;
    }

    @Override
    public Cart clearCart(Integer cartId) {
        Cart cart=null;
        Optional<Cart> cartOpt = cartDao.findById(cartId);

        if (cartOpt.isPresent()){
            cart=cartOpt.get();
            cart.getCartItems().removeAll(cart.getCartItems());
            cartItemDTODao.deleteItemDTOByCartId(cartId);
        }
        else{
            //Exception
        }
        return cart;
    }
}
