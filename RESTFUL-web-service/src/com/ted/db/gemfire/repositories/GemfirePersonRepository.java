package com.ted.db.gemfire.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ted.db.gemfire.entities.GemfirePerson;

public interface GemfirePersonRepository extends CrudRepository<GemfirePerson, String> {
	GemfirePerson findByName(String name);

	Iterable<GemfirePerson> findByAgeGreaterThan(int age);

	Iterable<GemfirePerson> findByAgeLessThan(int age);

	Iterable<GemfirePerson> findByAgeGreaterThanAndAgeLessThan(int age1, int age2);
}
