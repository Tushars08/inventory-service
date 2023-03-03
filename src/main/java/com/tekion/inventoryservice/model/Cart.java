package com.tekion.inventoryservice.model;



import org.springframework.data.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Cart {
    private List<CartItem> cartItems;

    public Cart(){
        cartItems = new ArrayList<CartItem>();
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public boolean hasItem(String itemId){
        for(int i = 0; i < cartItems.size(); i++){
            if(cartItems.get(i).getItemId().equals(itemId)){
                return true;
            }
        }
        return false;
    }

    public void updateCart(String itemId, Integer quantity){
        if(hasItem(itemId)){
            for(int i = 0; i < cartItems.size(); i++){
                if(cartItems.get(i).getItemId().equals(itemId)){
                    cartItems.set(i, new CartItem(itemId, quantity));
                    break;
                }
            }
        }
        else{
            cartItems.add(new CartItem(itemId, quantity));
        }
    }





}
