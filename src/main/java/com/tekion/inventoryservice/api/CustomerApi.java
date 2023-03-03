package com.tekion.inventoryservice.api;


import com.tekion.inventoryservice.model.Customer;
import com.tekion.inventoryservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerApi {


    CustomerService customerService;

    @PostMapping()
    public void addCustomer(@RequestBody Customer customer){
        customerService.addCustomer(customer);
    }

    @GetMapping()
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping("/{customerId}")
    public Customer getCustomer(@PathVariable String customerId){
        return customerService.getCustomer(customerId);
    }

    @PutMapping("/{customerId}")
    public void updateCustomer(@PathVariable String customerId, @RequestBody Customer customer){
        customerService.updateCustomer(customerId, customer);
    }

    @DeleteMapping("/{customerId}")
    public void updateCustomer(@PathVariable String customerId){
        customerService.deleteCustomer(customerId);
    }


}
