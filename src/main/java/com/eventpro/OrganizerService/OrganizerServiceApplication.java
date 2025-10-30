package com.eventpro.OrganizerService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class OrganizerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrganizerServiceApplication.class, args);
	}

}
