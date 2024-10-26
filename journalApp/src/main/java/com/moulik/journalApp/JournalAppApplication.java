package com.moulik.journalApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableScheduling
//@EnableAutoConfiguration
public class JournalAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(JournalAppApplication.class, args);

	}
//	@Bean
//	public PlatformTransactionManager database(MongoDatabaseFactory dbfactor){
//		return new MongoTransactionManager(dbfactor);
//
//	}
// implimentaion of REsttemplate
@Bean
public RestTemplate restTemplata(){
	return new RestTemplate();
}

}
