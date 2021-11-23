package com.example.travelguideservice.controller.user;


import com.example.travelguideservice.dto.order.OrderDto;
import com.example.travelguideservice.dto.user.OperationMessageDto;
import com.example.travelguideservice.dto.user.UserDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/v2/")
public class UserController {

    private Map<String, UserDto> users = new HashMap<>();



    @PostMapping(value = "user", consumes = "application/json", produces = "application/json")
    public ResponseEntity addUser (@RequestBody UserDto user){
        saveUser(user);
        return ResponseEntity.ok(user);
    }

    @PostMapping(value = "users", consumes = "application/json", produces = "application/json")
    public ResponseEntity addUsers (@RequestBody List<UserDto> users){
        users.forEach(this::saveUser);
        return ResponseEntity.ok(new OperationMessageDto("Successful operation"));
    }

    @GetMapping(value = "user/login", produces = "application/json")
    public ResponseEntity login(@RequestParam String username, @RequestParam String password){

        boolean isUsernameValidAndPasswordMatches = Optional.ofNullable(users.get(username))
                .map(user -> user.getPassword().equals(password)).orElse(false);

        HttpHeaders header = new HttpHeaders();

        header.add("X-Rate-Limit", "1800");
        header.add("X-Rate-Expires", LocalDateTime.now().plusHours(1).toString());

        return isUsernameValidAndPasswordMatches
                ? ResponseEntity.ok().headers(header).body(new OperationMessageDto("Successful operation"))
                : ResponseEntity.badRequest().body(new OperationMessageDto("Invalid username/password supplied"));
    }

    @GetMapping(value = "user/logout", produces = "application/json")
    public ResponseEntity logout(@RequestParam String username) {
        return ResponseEntity.ok().body(new OperationMessageDto("Successful operation"));
    }

    @GetMapping(value = "user/{username}", produces = "application/json")
    public ResponseEntity getUserByName(@RequestParam String username) {
        Optional<UserDto> foundUser = Optional.ofNullable(users.get(username));
        return foundUser.isPresent() ? ResponseEntity.ok(foundUser.get()) : ResponseEntity.noContent().build();
    }

    @PutMapping (value = "user/{username", consumes = "application/json", produces = "application/json")
    public ResponseEntity updateUser (@PathVariable String username, @RequestBody UserDto user){
        users.put(username, user);
        return ResponseEntity.ok(new OperationMessageDto("Successful operation"));
    }

    @DeleteMapping (value = "user/{username", produces = "application/json")
    public ResponseEntity deleteUser (@PathVariable String username){
        UserDto user = users.remove(username);
        return ResponseEntity.ok(user);
    }
    
    private void saveUser(@RequestBody UserDto user) {
        long latestId = users.size();
        user.setId(latestId);
        users.put(user.getUsername(), user);
    }

}
