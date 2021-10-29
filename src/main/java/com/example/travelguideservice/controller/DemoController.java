package com.example.travelguideservice.controller;


import com.example.travelguideservice.model.TestMessage;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")

public class DemoController {

    public List<TestMessage> list = new ArrayList<>();
    public long id = 2;

    public DemoController() {
        this.list.add(new TestMessage(1 ,"Message text from anton", "Anton"));
    }

    @GetMapping("/all-messages")
    public List<TestMessage> GetSimpleMessage(@RequestParam(required = false) Long id){
        return id != null
                ? list.stream().filter(item -> item.getId() < id).collect(Collectors.toList())
                : list;
    }

    @PostMapping("/add")
    public TestMessage CreateMessage(@RequestParam String text, @RequestParam String author){
        TestMessage message = new TestMessage(id++, text, author);
        list.add(message);
        return message;
    }

}
