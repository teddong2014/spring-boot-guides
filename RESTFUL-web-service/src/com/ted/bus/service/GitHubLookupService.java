package com.ted.bus.service;

import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ted.bus.model.AsyncModel;

@Service
public class GitHubLookupService {

	@Autowired
    private RestTemplate restTemplate;

    @Async
    public Future<AsyncModel> findUser(String user) throws InterruptedException {
        System.out.println("Looking up " + user);
        AsyncModel results = restTemplate.getForObject("https://api.github.com/users/" + user, AsyncModel.class);
        // Artificial delay of 1s for demonstration purposes
        Thread.sleep(1000L);
        return new AsyncResult<AsyncModel>(results);
    }

}
