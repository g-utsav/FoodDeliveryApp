package com.foodDelivery.dataAcessLayer;

import com.foodDelivery.entity.CartItemDTO1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemDTODao extends JpaRepository<CartItemDTO1,Integer> {

    @Query ("delete from CartItemDTO1 cdto where cdto.cartId=?1")
    public void deleteItemDTOByCartId(Integer cartId);
}
