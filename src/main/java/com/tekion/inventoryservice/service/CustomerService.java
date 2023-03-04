package com.tekion.inventoryservice.service;

import com.tekion.inventoryservice.model.Customer;

import java.util.List;

public interface CustomerService {
    Customer addCustomer(Customer customer);

    List<Customer> getAllCustomers();

    Customer getCustomer(Integer customerId);

    void updateCustomer(Integer customerId, Customer customer);

    void deleteCustomer(Integer customerId);
}
