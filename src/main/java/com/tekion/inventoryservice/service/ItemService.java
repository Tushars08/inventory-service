package com.tekion.inventoryservice.service;

import com.tekion.inventoryservice.model.Item;

import java.util.List;

public interface ItemService {
    void addItem(Item item);

    Item getItem(String id);

    List<Item> getAllItems();

    void updateItem(Item item);

    void deleteItem(String id);
}
