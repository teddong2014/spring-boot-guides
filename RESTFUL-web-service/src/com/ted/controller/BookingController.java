package com.ted.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ted.bus.service.BookingService;

@RestController
@RequestMapping(value="/booking")
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
	@RequestMapping(value="/book", method=RequestMethod.GET)
    public void book() {
        bookingService.book("p1", null);
    }
	
	@RequestMapping(value="/find-all", method=RequestMethod.GET)
    public List<String> findAllBooks() {
        return bookingService.findAllBookings();
    }
}
