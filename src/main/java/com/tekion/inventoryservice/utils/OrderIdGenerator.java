package com.tekion.inventoryservice.utils;

import org.springframework.stereotype.Component;

@Component
public class OrderIdGenerator {
    private Integer orderNo = 1;
    public Integer generateId(){
        return orderNo++;
    }
}
