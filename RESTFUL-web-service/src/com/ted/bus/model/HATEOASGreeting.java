package com.ted.bus.model;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class HATEOASGreeting extends ResourceSupport {
	private final String content;

	@JsonCreator
	public HATEOASGreeting(@JsonProperty("content") String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}
}
