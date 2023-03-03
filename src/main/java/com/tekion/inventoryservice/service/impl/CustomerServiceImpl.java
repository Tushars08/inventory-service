package com.tekion.inventoryservice.service.impl;

import com.tekion.inventoryservice.model.Customer;
import com.tekion.inventoryservice.service.CartService;
import com.tekion.inventoryservice.service.CustomerService;
import com.tekion.inventoryservice.service.repository.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepo customerRepo;
    CartService cartService;
    @Override
    public void addCustomer(Customer customer) {
        customerRepo.save(customer);
        cartService.createCart(customer.getCustomerId());
    }


    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<Customer>();
        customerRepo.findAll().forEach(customer -> customers.add(customer));
        return customers;
    }

    @Override
    public Customer getCustomer(String customerId) {
        return null;
    }

    @Override
    public void updateCustomer(String customerId, Customer customer) {

    }

    @Override
    public void deleteCustomer(String customerId) {

    }
}
