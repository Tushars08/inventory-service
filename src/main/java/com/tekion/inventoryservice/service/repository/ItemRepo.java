package com.tekion.inventoryservice.service.repository;

import com.tekion.inventoryservice.model.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepo extends CrudRepository<Item, String> {
}
