package com.ted.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ted.bus.model.HATEOASGreeting;

@RestController
@RequestMapping("/hateoas")
public class HATEOASGreetingController {
	private static final String TEMPLATE = "Hello, %s!";

    @RequestMapping("/greeting")
    public HttpEntity<HATEOASGreeting> greeting(
            @RequestParam(value = "name", required = false, defaultValue = "World") String name) {

    	HATEOASGreeting greeting = new HATEOASGreeting(String.format(TEMPLATE, name));
        greeting.add(linkTo(methodOn(HATEOASGreetingController.class).greeting(name)).withSelfRel());

        return new ResponseEntity<HATEOASGreeting>(greeting, HttpStatus.OK);
    }
    
    @RequestMapping("/greeting2")
    public HATEOASGreeting greeting2(
            @RequestParam(value = "name", required = false, defaultValue = "World") String name) {

    	HATEOASGreeting greeting = new HATEOASGreeting(String.format(TEMPLATE, name));
        greeting.add(linkTo(methodOn(HATEOASGreetingController.class).greeting(name)).withSelfRel());

        return greeting;
    }
}
