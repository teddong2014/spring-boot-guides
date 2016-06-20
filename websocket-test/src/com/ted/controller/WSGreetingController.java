package com.ted.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.ted.controller.model.in.WSHelloMessage;
import com.ted.controller.model.out.WSGreeting;

@Controller
public class WSGreetingController {


    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public WSGreeting greeting(WSHelloMessage message) throws Exception {
        Thread.sleep(3000); // simulated delay
        return new WSGreeting("Hello, " + message.getName() + "!");
    }

}