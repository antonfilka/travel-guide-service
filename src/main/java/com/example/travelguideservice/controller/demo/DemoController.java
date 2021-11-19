package com.example.travelguideservice.controller.demo;


import com.example.travelguideservice.model.demo.TestMessage;
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

//    @PostMapping("/add")
//    public TestMessage CreateMessage(@RequestParam String text, @RequestParam String author){
//        TestMessage message = new TestMessage(id++, text, author);
//        list.add(message);
//        return message;
//    }


    @PostMapping("/add")
    public TestMessage CreateMessage(@RequestBody TestMessage inputMessage){
        TestMessage message = new TestMessage(id++, inputMessage.getText(), inputMessage.getAuthor());
        list.add(message);
        return message;
    }

    @PostMapping("/remove/{id}")
    public TestMessage RemoveMessage(@PathVariable("id") Long requestedID){
        TestMessage message = list.stream().filter(item -> item.getId() == requestedID).findFirst().get();
        list.remove(message);
        return message;
    }

    @PostMapping("/update/{id}")
    public TestMessage UpdateMessage(@PathVariable("id") Long requestedID, @RequestBody TestMessage inputMessage){
        TestMessage message = list.stream().filter(item -> item.getId() == requestedID).findFirst().get();
        message.setText(inputMessage.getText());
        message.setAuthor(inputMessage.getAuthor());
        return message;
    }

}
