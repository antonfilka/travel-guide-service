package controller;


import model.TestMessage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DemoController {


    public TestMessage GetSimpleMessage(){
        return new TestMessage("Test message", "Anton");
    }


}
