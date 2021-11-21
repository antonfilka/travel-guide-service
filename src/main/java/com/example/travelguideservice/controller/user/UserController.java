package com.example.travelguideservice.controller.user;


import com.example.travelguideservice.dto.order.OrderDto;
import com.example.travelguideservice.dto.user.OperationMessageDto;
import com.example.travelguideservice.dto.user.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v2/user")
public class UserController {

    private Map<String, UserDto> users = new HashMap<>();

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity addUser (@RequestBody UserDto user){
        saveUser(user);
        return ResponseEntity.ok(user);
    }

    @PostMapping(value = "s", consumes = "application/json", produces = "application/json")
    public ResponseEntity addUsers (@RequestBody List<UserDto> users){
        users.forEach(this::saveUser);
        return ResponseEntity.ok(new OperationMessageDto("Successful operation"));
    }

    private void saveUser(@RequestBody UserDto user) {
        long latestId = users.size();
        user.setId(latestId);
        users.put(user.getUsername(), user);
    }

}
