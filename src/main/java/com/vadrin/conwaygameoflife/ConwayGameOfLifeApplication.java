package com.vadrin.conwaygameoflife;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ConwayGameOfLifeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConwayGameOfLifeApplication.class, args);
	}
}
