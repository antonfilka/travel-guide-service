package com.example.travelguideservice.controller.store;


import com.example.travelguideservice.dto.order.OrderDto;
import com.example.travelguideservice.dto.pet.PetDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v2/store")
public class StoreController {

    private Map<Long, OrderDto> orders = new HashMap<>();

    @PostMapping(value = "/order", consumes = "application/json", produces = "application/json")
    public ResponseEntity addOrder (@RequestBody OrderDto order){
        long latestId = orders.size();
        order.setId(latestId);
        orders.put(latestId, order);

        return ResponseEntity.ok(order);
    }

    @GetMapping(value = "/order/{orderId}", produces = "application/json")
    public ResponseEntity getOrderById(@PathVariable Long orderId){
        OrderDto order = orders.get(orderId);
        return ResponseEntity.ok(order);
    }

    @DeleteMapping(value = "/order/{orderId}", produces = "application/json")
    public ResponseEntity deleteOrder(@PathVariable Long orderId){
        OrderDto order = orders.remove(orderId);
        return ResponseEntity.ok(order);
    }

}
