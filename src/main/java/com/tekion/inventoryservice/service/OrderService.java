package com.tekion.inventoryservice.service;

import com.tekion.inventoryservice.model.Cart;
import com.tekion.inventoryservice.model.CartItem;
import com.tekion.inventoryservice.model.Order;

import java.util.List;

public interface OrderService {
    public Order addOrder(Integer customerId);
    public Order addOrder(Order order);
    public void removeOrder(Integer orderId);
    public List<Order> getAllOrders();

    Order getOrderById(Integer orderId);
//    public Integer getTotalAmount(List<CartItem> cartItems);
}
