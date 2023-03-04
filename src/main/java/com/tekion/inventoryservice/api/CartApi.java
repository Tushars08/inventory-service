package com.tekion.inventoryservice.api;

import com.tekion.inventoryservice.model.Cart;
import com.tekion.inventoryservice.model.CartItem;
import com.tekion.inventoryservice.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carts")
public class CartApi {

    @Autowired
    CartService cartService;

    @PostMapping("/{customerId}/{itemId}/{quantity}")
    public void updateCart(@PathVariable Integer customerId, @PathVariable String itemId, @PathVariable Integer quantity){
        cartService.updateCart(customerId, itemId, quantity);
    }

    @GetMapping("/{customerId}")
    public List<CartItem> getCartItems(@PathVariable Integer customerId){
        return cartService.getCartItems(customerId);
    }

}
