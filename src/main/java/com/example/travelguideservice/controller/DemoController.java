package com.example.travelguideservice.controller;


import com.example.travelguideservice.model.TestMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")

public class DemoController {

    @GetMapping("/hello")
    public TestMessage GetSimpleMessage(){
        return new TestMessage("Message text from anton", "Anton");
    }


}
