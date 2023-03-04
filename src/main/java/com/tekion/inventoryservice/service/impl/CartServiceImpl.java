package com.tekion.inventoryservice.service.impl;

import com.tekion.inventoryservice.model.CartItem;
import com.tekion.inventoryservice.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import com.tekion.inventoryservice.model.Cart;

import java.util.HashMap;
import java.util.List;


@Component
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private HashMap<Integer, Cart> customerCartMap;


    public void createCart(Integer customerId){
        if(customerCartMap == null){
            customerCartMap = new HashMap<Integer, Cart>();
        }
        customerCartMap.put(customerId, new Cart());
    }
    public void removeCart(Integer customerId){
        customerCartMap.remove(customerId);
    }
    public List<CartItem> getCartItems(Integer customerId){
        Cart cart = customerCartMap.get(customerId);
        return cart.getCartItems();
    }
    public void updateCart(Integer customerId, String itemId, Integer quantity){
        if(quantity.equals(0)){
            customerCartMap.get(customerId).deleteCartItem(itemId);
        }
        else{
            customerCartMap.get(customerId).updateCartItem(itemId, quantity);
        }
    }

    @Override
    public void deleteCart(Integer customerId) {
        customerCartMap.remove(customerId);
    }
}
