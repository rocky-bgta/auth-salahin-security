package com.auth.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j(topic = "Main Function")
public class OauthSalahinSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(OauthSalahinSecurityApplication.class, args);
		log.info("Application started");
	}

}
