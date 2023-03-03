package com.tekion.inventoryservice.service.repository;

import com.tekion.inventoryservice.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepo extends CrudRepository<Customer, Integer> {
}
