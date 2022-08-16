package com.foodDelivery.dataAcessLayer;

import com.foodDelivery.entity.ItemDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemDTODao extends JpaRepository<ItemDTO,Integer> {

    @Query ("delete from ItemDTO i where i.cart.cartId=?1")
    public void deleteItemDTOByCartId(Integer cartId);
}
