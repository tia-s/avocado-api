package edu.unb.tiashack.avocado_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "edu.unb.tiashack.avocado_api")
public class AvocadoApiApplication {

	public static void main(String[] args) {
		System.out.println("Running APIs...");
		SpringApplication.run(AvocadoApiApplication.class, args);

	}



}
