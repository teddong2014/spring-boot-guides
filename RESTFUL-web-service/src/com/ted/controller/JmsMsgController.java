package com.ted.controller;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value="/jms/msg")
public class JmsMsgController {
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@RequestMapping(value="/send", method=RequestMethod.GET)
	public void send(@RequestParam(value="content") String content) {
		log.info("Sending JMS message...");
		MessageCreator messageCreator = new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(content);
            }
        };
		jmsTemplate.send("mailbox-destination", messageCreator);
	}
}
