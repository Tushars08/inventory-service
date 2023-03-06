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
    @Autowired
    CartService cartService;
    @Override
    public Customer addCustomer(Customer customer) {
        Customer newCustomer = customerRepo.save(customer);
        cartService.createCart(newCustomer.getCustomerId());
        return newCustomer;
    }


    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        customerRepo.findAll().forEach(customers::add);
        return customers;
    }

    @Override
    public Customer getCustomer(Integer customerId) {
        return customerRepo.findById(customerId).orElse(null);
    }

    @Override
    public void updateCustomer(Integer customerId, Customer customer) {
        customerRepo.save(customer);
    }

    @Override
    public void deleteCustomer(Integer customerId) {
        customerRepo.deleteById(customerId);
        cartService.deleteCart(customerId);
    }
}
