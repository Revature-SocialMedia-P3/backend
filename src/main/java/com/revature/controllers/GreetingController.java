package com.revature.controllers;

import com.revature.models.GreetingMessage;
import com.revature.models.HelloMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {
    @MessageMapping("/chatroom")
    @SendTo("/topic/greetings")
    @CrossOrigin(origins = {"http://localhost:4200", "http://localhost:3000"}, allowCredentials = "true")
    public GreetingMessage greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new GreetingMessage("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }
}
