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

    @GetMapping("/{itemId}")
    public Item getItem(@PathVariable String itemId){
        return itemService.getItem(itemId);
    }

    @GetMapping()
    public List<Item> getAllItems(){
        return itemService.getAllItems();
    }

    @PutMapping()
    public void updateItem( @RequestBody Item item){
        itemService.updateItem(item);
    }

    @DeleteMapping("/{itemId}")
    public void deleteItem(@PathVariable String itemId){
        itemService.deleteItem(itemId);

    }




}
