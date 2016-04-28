package com.ted.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ted.bus.model.Quote;
import com.ted.bus.service.QuoteService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value="/gemfire/quote")
public class GemfireCacheController {
	@Autowired
	private QuoteService quoteService;
	
	@RequestMapping(value="/random", method=RequestMethod.GET)
    public Quote random() {
        return quoteService.requestRandomQuote();
    }
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public Quote requestById(@PathParam(value="id") Long id) {
		log.info("---------------------------GemfireCacheController------------------");
		return quoteService.requestQuote(id);
	}
}
