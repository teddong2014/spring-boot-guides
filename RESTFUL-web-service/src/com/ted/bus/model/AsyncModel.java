package com.ted.bus.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.ToString;

@JsonIgnoreProperties(ignoreUnknown=true)
@Data
@ToString
public class AsyncModel {
	private String name;
    private String blog;
}
