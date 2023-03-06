package com.tekion.inventoryservice.service.repository;

import com.tekion.inventoryservice.model.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class OrderRepo {
    private final List<Order> orders = new ArrayList<>();

    public Order addOrder(Order order){
        orders.add(order);
        return order;
    }

    public List<Order> getAllOrders(){
        return orders;
    }

    public Optional<Order> getOrderById(Integer orderId){
        return orders.stream().filter(order -> order.getOrderId().equals(orderId)).findFirst();
    }

    public void removeOrder(Integer orderId) throws NullPointerException{
        orders.remove(orders.stream().filter(order -> order.getOrderId().equals(orderId)).findFirst().orElse(null));
    }
}
