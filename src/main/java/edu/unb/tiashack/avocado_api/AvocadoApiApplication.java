package edu.unb.tiashack.avocado_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class AvocadoApiApplication {

	public static void main(String[] args) {
		System.out.println("Running API...");
		SpringApplication.run(AvocadoApiApplication.class, args);
	}

}
