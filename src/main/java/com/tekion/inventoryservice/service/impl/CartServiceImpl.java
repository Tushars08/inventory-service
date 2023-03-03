package com.tekion.inventoryservice.service.impl;

import com.tekion.inventoryservice.model.CartItem;
import com.tekion.inventoryservice.service.CartService;
import org.springframework.stereotype.Component;
import com.tekion.inventoryservice.model.Cart;

import java.util.HashMap;
import java.util.List;


@Component
public class CartServiceImpl implements CartService {
    private HashMap<Integer, Cart> customerCartMap;


    public void createCart(Integer customerId){
        if(customerCartMap.equals(null)){
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
        customerCartMap.get(customerId).updateCart(itemId, quantity);
    }

    @Override
    public void deleteCart(Integer customerId) {
        customerCartMap.remove(customerId);
    }
}
