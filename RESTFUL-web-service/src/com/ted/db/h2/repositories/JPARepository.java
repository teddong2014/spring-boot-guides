package com.ted.db.h2.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ted.db.h2.entities.JPAEntity;

public interface JPARepository extends CrudRepository<JPAEntity, Long> {
	List<JPAEntity> findByLastName(String lastName);
}
