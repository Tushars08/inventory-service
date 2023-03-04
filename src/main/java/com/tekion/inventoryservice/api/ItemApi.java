package com.tekion.inventoryservice.api;

import com.tekion.inventoryservice.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.tekion.inventoryservice.model.Item;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemApi {
    @Autowired
    ItemService itemService;

    @PostMapping()
    public void addItem(@RequestBody Item item){
        itemService.addItem(item);
    }

    @GetMapping("/{id}")
    public Item getItem(@PathVariable String id){
        return itemService.getItem(id);
    }

    @GetMapping()
    public List<Item> getAllItems(){
        return itemService.getAllItems();
    }

    @PutMapping()
    public void updateItem( @RequestBody Item item){
        itemService.updateItem(item);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable String id){
        itemService.deleteItem(id);
    }
}
