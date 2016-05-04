package com.ted.controller;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ted.bus.model.AsyncModel;
import com.ted.bus.service.GitHubLookupService;

@RestController
@RequestMapping(value = "/user")
public class AsyncController {

	@Autowired
	private GitHubLookupService gitHubLookupService;

	@RequestMapping(value = "/find/async", method = RequestMethod.GET)
	public AsyncModel asyncFind(@RequestParam(value = "name", defaultValue = "PivotalSoftware") String name)
			throws InterruptedException, ExecutionException {
		Future<AsyncModel> asyncResult = gitHubLookupService.findUser(name);
		return asyncResult.get();
	}
}
