package com.ted.config;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.Neo4jConfiguration;

//@Configuration
//@EnableNeo4jRepositories(basePackages = "com.ted.neo4j")
public class MyNeo4jConfiguration extends Neo4jConfiguration {
	public MyNeo4jConfiguration() {
		setBasePackage("com.ted.neo4j");
	}

	@Bean
	GraphDatabaseService graphDatabaseService() {
		return new GraphDatabaseFactory().newEmbeddedDatabase("neo4j.db");
	}
}
