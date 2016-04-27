package com.ted.broker.jms.receivers;

import java.io.File;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.util.FileSystemUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class JmsReceiver {
    /**
     * When you receive a message, print it out, then shut down the application.
     * Finally, clean up any ActiveMQ server stuff.
     */
    @JmsListener(destination = "mailbox-destination", containerFactory = "myJmsContainerFactory")
    public void receiveMessage(String message) {
    	log.info("Received <" + message + ">");
        FileSystemUtils.deleteRecursively(new File("activemq-data"));
    }
}
