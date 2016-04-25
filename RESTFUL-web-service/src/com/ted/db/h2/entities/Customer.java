package com.ted.db.h2.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customer {
	private long id;
    private String firstName, lastName;
}
