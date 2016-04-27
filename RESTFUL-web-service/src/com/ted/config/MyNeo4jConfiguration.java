package com.ted.config;

import java.util.Arrays;
import java.util.List;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.core.GraphDatabase;

import com.ted.db.neo4j.Person;
import com.ted.db.neo4j.PersonRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
// @Configuration
// @EnableNeo4jRepositories(basePackages = "com.ted.neo4j")
public class MyNeo4jConfiguration extends Neo4jConfiguration {
	public MyNeo4jConfiguration() {
		setBasePackage("com.ted.neo4j");
	}

	@Bean
	GraphDatabaseService graphDatabaseService() {
		return new GraphDatabaseFactory().newEmbeddedDatabase("neo4j.db");
	}

	CommandLineRunner initNeo4j(PersonRepository personRepository, GraphDatabase graphDatabase) throws Exception {
		// FileUtils.deleteRecursively(new File("neo4j.db"));

		return args -> {

			Person greg = new Person("Greg");
			Person roy = new Person("Roy");
			Person craig = new Person("Craig");

			List<Person> team = Arrays.asList(greg, roy, craig);

			log.info("Before linking up with Neo4j...");

			team.stream().forEach(person -> log.info("\t" + person.toString()));

			Transaction tx = graphDatabase.beginTx();
			try {
				personRepository.save(greg);
				personRepository.save(roy);
				personRepository.save(craig);

				greg = personRepository.findByName(greg.getName());
				greg.worksWith(roy);
				greg.worksWith(craig);
				personRepository.save(greg);

				roy = personRepository.findByName(roy.getName());
				roy.worksWith(craig);
				// We already know that roy works with greg
				personRepository.save(roy);

				// We already know craig works with roy and greg

				log.info("Lookup each person by name...");
				team.stream()
						.forEach(person -> log.info("\t" + personRepository.findByName(person.getName()).toString()));

				log.info("Lookup each person by teammate...");
				for (Person person : team) {
					log.info(person.getName() + " is a teammate of...");
					personRepository.findByTeammatesName(person.getName()).stream()
							.forEach(teammate -> log.info("\t" + teammate.getName()));
				}

				tx.success();
			} finally {
				tx.close();
			}
		};
	}
}
