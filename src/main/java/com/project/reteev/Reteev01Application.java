package com.project.reteev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class Reteev01Application {

	public static void main(String[] args) {
		SpringApplication.run(Reteev01Application.class, args);
	}

}
