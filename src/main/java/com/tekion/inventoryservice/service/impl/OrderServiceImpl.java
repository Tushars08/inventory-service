package com.tekion.inventoryservice.service.impl;

import com.tekion.inventoryservice.model.Cart;
import com.tekion.inventoryservice.model.CartItem;
import com.tekion.inventoryservice.model.Item;
import com.tekion.inventoryservice.model.Order;
import com.tekion.inventoryservice.service.CartService;
import com.tekion.inventoryservice.service.ItemService;
import com.tekion.inventoryservice.service.OrderService;
import com.tekion.inventoryservice.service.repository.ItemRepo;
import com.tekion.inventoryservice.service.repository.OrderRepo;
import com.tekion.inventoryservice.utils.OrderIdGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderIdGenerator orderIdGenerator;
    @Autowired
    CartService cartService;
    @Autowired
    ItemRepo itemRepo;
    @Autowired
    OrderRepo orderRepo;

    private Integer getTotalAmount(List<CartItem> cartItems) {
        Integer total = 0;
        for (CartItem cartItem : cartItems) {
            total += (itemRepo.findById(cartItem.getItemId()).orElse(new Item())).getPrice() * cartItem.getQuantity();
        }
        return total;
    }

    @Override
    public Order addOrder(Integer customerId) {
        List<CartItem> cartItems = cartService.getCartItems(customerId);
        return orderRepo.addOrder(new Order(orderIdGenerator.generateId(), customerId, cartItems, getTotalAmount(cartItems)));
    }

    @Override
    public Order addOrder(Order order) {
        return null;
    }

    @Override
    public void removeOrder(Integer orderId) {
        orderRepo.removeOrder(orderId);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepo.getAllOrders();
    }

    @Override
    public Order getOrderById(Integer orderId) {
        return orderRepo.getOrderById(orderId).orElse(null);
    }
}
