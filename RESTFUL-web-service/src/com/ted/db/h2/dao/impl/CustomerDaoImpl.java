package com.ted.db.h2.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.ted.db.h2.dao.CustomerDao;
import com.ted.db.h2.entities.Customer;

@Component(value="customerDao")
public class CustomerDaoImpl implements CustomerDao {
	
	private static final Logger log = LoggerFactory.getLogger(CustomerDaoImpl.class);
	
	@Autowired
    private JdbcTemplate jdbcTemplate;

	@Override
	public Customer query(String firstName) {
		log.info("Querying for customer records where first_name = 'Josh':");
        return jdbcTemplate.query(
                "SELECT id, first_name, last_name FROM customers WHERE first_name = ?", 
                new Object[] { firstName },
                (rs, rowNum) -> new Customer(
                		rs.getLong("id"), 
                		rs.getString("first_name"), 
                		rs.getString("last_name"))
        ).get(0);
	}
}
