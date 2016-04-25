package com.ted.db.h2.dao;

import com.ted.db.h2.entities.Customer;

public interface CustomerDao {
	Customer query(String firstName);
}
