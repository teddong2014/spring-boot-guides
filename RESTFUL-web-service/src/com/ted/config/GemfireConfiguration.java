package com.ted.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.gemfire.CacheFactoryBean;
import org.springframework.data.gemfire.LocalRegionFactoryBean;
import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;

import com.gemstone.gemfire.cache.GemFireCache;
import com.ted.db.gemfire.entities.GemfirePerson;
import com.ted.db.gemfire.repositories.GemfirePersonRepository;

@Configuration
@EnableGemfireRepositories(basePackages="com.ted.db.gemfire.repositories")
public class GemfireConfiguration {
	@Bean
    Properties gemfireProperties() {
        Properties gemfireProperties = new Properties();
        gemfireProperties.setProperty("name", "DataGemFireApplication");
        gemfireProperties.setProperty("mcast-port", "0");
        gemfireProperties.setProperty("log-level", "config");
        return gemfireProperties;
    }
    
    @Bean
    CacheFactoryBean gemfireCache() {
        CacheFactoryBean gemfireCache = new CacheFactoryBean();
        gemfireCache.setClose(true);
        gemfireCache.setProperties(gemfireProperties());
        return gemfireCache;
    }
    
    @Bean
    LocalRegionFactoryBean<String, GemfirePerson> helloRegion(final GemFireCache cache) {
        LocalRegionFactoryBean<String, GemfirePerson> helloRegion = new LocalRegionFactoryBean<>();
        helloRegion.setCache(cache);
        helloRegion.setClose(false);
        helloRegion.setName("hello");
        helloRegion.setPersistent(false);
        return helloRegion;
    }
    
    @Autowired
    GemfirePersonRepository gemfirePersonRepository;
    
    @Bean
    CommandLineRunner initGemfire() {
    	return args -> {
    		GemfirePerson alice = new GemfirePerson("Alice", 40);
    		GemfirePerson bob = new GemfirePerson("Baby Bob", 1);
    		GemfirePerson carol = new GemfirePerson("Teen Carol", 13);

            System.out.println("Before linking up with Gemfire...");
            for (GemfirePerson person : new GemfirePerson[] { alice, bob, carol }) {
                System.out.println("\t" + person);
            }

            gemfirePersonRepository.save(alice);
            gemfirePersonRepository.save(bob);
            gemfirePersonRepository.save(carol);

            System.out.println("Lookup each person by name...");
            for (String name : new String[] { alice.name, bob.name, carol.name }) {
                System.out.println("\t" + gemfirePersonRepository.findByName(name));
            }

            System.out.println("Adults (over 18):");
            for (GemfirePerson person : gemfirePersonRepository.findByAgeGreaterThan(18)) {
                System.out.println("\t" + person);
            }

            System.out.println("Babies (less than 5):");
            for (GemfirePerson person : gemfirePersonRepository.findByAgeLessThan(5)) {
                System.out.println("\t" + person);
            }

            System.out.println("Teens (between 12 and 20):");
            for (GemfirePerson person : gemfirePersonRepository.findByAgeGreaterThanAndAgeLessThan(12, 20)) {
                System.out.println("\t" + person);
            }
    	};
    }
}
