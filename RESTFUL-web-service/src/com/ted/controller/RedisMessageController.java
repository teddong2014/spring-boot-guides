package com.ted.controller;

import java.util.concurrent.CountDownLatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value="/redis/msg")
public class RedisMessageController {
	
	@Autowired
	private CountDownLatch latch;
	
	@Autowired
    private StringRedisTemplate template;
	
	@RequestMapping(value="/send", method=RequestMethod.GET)
    public void send(@RequestParam(value="content") String content) throws InterruptedException {
		log.info("Sending message...");
		template.convertAndSend("chat", content);
		
		latch.await();
    }
}
