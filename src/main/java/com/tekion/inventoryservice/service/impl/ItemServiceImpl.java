package com.tekion.inventoryservice.service.impl;

import com.tekion.inventoryservice.model.Item;
import com.tekion.inventoryservice.service.ItemService;
import com.tekion.inventoryservice.service.repository.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepo itemRepo;

    @Override
    public void addItem(Item item) {
        itemRepo.save(item);
    }

    @Override
    public Item getItem(String id) {
        return itemRepo.findById(id).orElse(null);
    }

    @Override
    public List<Item> getAllItems() {
        List<Item> items = new ArrayList<>();
        itemRepo.findAll().forEach(items::add);
        return items;
    }

    @Override
    public void updateItem(Item item) {
        itemRepo.save(item);
    }

    @Override
    public void deleteItem(String id) {
        itemRepo.deleteById(id);
    }
}
