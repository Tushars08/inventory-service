package com.tekion.inventoryservice.api;

import com.tekion.inventoryservice.model.Order;
import com.tekion.inventoryservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class orderApi {
    @Autowired
    OrderService orderService;

    @GetMapping("/{customerId}/order")
    public Order makeOrder(@PathVariable Integer customerId){
        Order order = orderService.addOrder(customerId);
        return order;
    }

    @GetMapping("/orders")
    public List<Order> getAllOrder(){
        return orderService.getAllOrders();
    }

    @GetMapping("/orders/{orderId}")
    public Order getOrderById(@PathVariable Integer orderId){
        return orderService.getOrderById(orderId);
    }

    @DeleteMapping("orders/{orderId}")
    public void deleteOrder(@PathVariable Integer orderId){
        orderService.removeOrder(orderId);
    }
}
