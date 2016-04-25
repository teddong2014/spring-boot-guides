package com.ted.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ted.db.h2.dao.CustomerDao;
import com.ted.db.h2.entities.Customer;

@RestController
@RequestMapping(value="/customer")
public class CustomerController {
	
	@Autowired
	private CustomerDao customerDao;
	
	@RequestMapping(value="/query", method=RequestMethod.GET)
    public Customer greeting(@RequestParam(value="firstName", defaultValue="John Woo") String firstName) {
        return customerDao.query(firstName);
    }
}
