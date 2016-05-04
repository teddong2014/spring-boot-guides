package com.ted.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ted.db.h2.entities.JPAEntity;
import com.ted.db.h2.repositories.JPARepository;

@RestController
@RequestMapping(value="/jpaentity")
public class JPAEntityController {
	
	@Autowired
	private JPARepository jpaRepository;
	
	@RequestMapping(value="/qry_by_lastnm", method=RequestMethod.GET)
    public List<JPAEntity> queryByLastName(@RequestParam(value="lastName", defaultValue="J") String lastName) {
        return jpaRepository.findByLastName(lastName);
    }
}
