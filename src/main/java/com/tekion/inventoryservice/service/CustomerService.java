package com.tekion.inventoryservice.service;

import com.tekion.inventoryservice.model.Customer;

import java.util.List;

public interface CustomerService {
    void addCustomer(Customer customer);

    List<Customer> getAllCustomers();

    Customer getCustomer(String customerId);

    void updateCustomer(String customerId, Customer customer);

    void deleteCustomer(String customerId);
}
