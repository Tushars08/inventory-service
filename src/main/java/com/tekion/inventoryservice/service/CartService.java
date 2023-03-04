package com.tekion.inventoryservice.service;

import com.tekion.inventoryservice.model.CartItem;

import java.util.List;

public interface CartService {
    void createCart(Integer customerId);
    void removeCart(Integer customerId);
    List<CartItem> getCartItems(Integer customerId);
    void updateCart(Integer customerId, String itemId, Integer quantity) ;
    void deleteCart(Integer customerId);
}
