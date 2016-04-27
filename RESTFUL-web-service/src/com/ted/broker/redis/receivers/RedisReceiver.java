package com.ted.broker.redis.receivers;

import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class RedisReceiver {
	private static final Logger LOGGER = LoggerFactory.getLogger(RedisReceiver.class);

	private CountDownLatch latch;

	@Autowired
	public RedisReceiver(CountDownLatch latch) {
		this.latch = latch;
	}

	public void receiveMessage(String message) {
		LOGGER.info("Received <" + message + ">");
		latch.countDown();
	}
}