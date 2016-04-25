package com.ted;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;

import org.neo4j.graphdb.Transaction;
import org.neo4j.io.fs.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.core.GraphDatabase;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ted.broker.redis.receivers.Receiver;
import com.ted.db.neo4j.Person;
import com.ted.db.neo4j.PersonRepository;

import redis.clients.jedis.JedisShardInfo;

@SpringBootApplication
//@EnableScheduling
public class Application {
	
	public static final String ROOT = "E:\\tmp";
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(Application.class, args);
    }
    
    /*@Bean
	CommandLineRunner initNeo4j(PersonRepository personRepository,
						   GraphDatabase graphDatabase) throws Exception {
//    	FileUtils.deleteRecursively(new File("neo4j.db"));
    	
		return args -> {

			Person greg = new Person("Greg");
			Person roy = new Person("Roy");
			Person craig = new Person("Craig");

			List<Person> team = Arrays.asList(greg, roy, craig);

			log.info("Before linking up with Neo4j...");

			team.stream()
				.forEach(person -> log.info("\t" + person.toString()));

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
					.forEach(person ->
						log.info("\t" + personRepository
								.findByName(person.getName()).toString()));


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
	}*/
    
    @Bean
    CommandLineRunner initDB() {
    	return (String[] args) -> {
    		log.info("Creating tables");
    		
    		jdbcTemplate.execute("DROP TABLE customers IF EXISTS");
    		jdbcTemplate.execute("CREATE TABLE customers(" +
    				"id SERIAL, first_name VARCHAR(255), last_name VARCHAR(255))");
    		
    		// Split up the array of whole names into an array of first/last names
    		List<Object[]> splitUpNames = Arrays.asList("John Woo", "Jeff Dean", "Josh Bloch", "Josh Long").stream()
    				.map(name -> name.split(" "))
    				.collect(Collectors.toList());
    		
    		// Use a Java 8 stream to print out each tuple of the list
    		splitUpNames.forEach(name -> log.info(String.format("Inserting customer record for %s %s", name[0], name[1])));
    		
    		// Uses JdbcTemplate's batchUpdate operation to bulk load data
    		jdbcTemplate.batchUpdate("INSERT INTO customers(first_name, last_name) VALUES (?,?)", splitUpNames);
    	};
    }
    
    @Bean
	RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory,
			MessageListenerAdapter listenerAdapter) {

		RedisMessageListenerContainer container = new RedisMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.addMessageListener(listenerAdapter, new PatternTopic("chat"));

		return container;
	}

	@Bean
	MessageListenerAdapter listenerAdapter(Receiver receiver) {
		return new MessageListenerAdapter(receiver, "receiveMessage");
	}

	@Bean
	Receiver receiver(CountDownLatch latch) {
		return new Receiver(latch);
	}

	@Bean
	CountDownLatch latch() {
		return new CountDownLatch(1);
	}

	@Bean
	StringRedisTemplate template(RedisConnectionFactory connectionFactory) {
		return new StringRedisTemplate(connectionFactory);
	}
	
	@Bean
	RedisConnectionFactory redisFactory() {
		JedisShardInfo sharedInfo = new JedisShardInfo("192.168.2.129", 6379);
//		sharedInfo.setPassword("");
		return new JedisConnectionFactory(sharedInfo);
	}
}