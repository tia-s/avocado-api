/**
 * Main class for the Avocado API application.
 * This serves as the entry point to the Spring Boot application, initializing and starting 
 * the application context and its components.
 *
 * Responsibilities:
 * - Bootstraps the application using SpringApplication.run().
 * - Sets up the application to scan components in the "edu.unb.tiashack.avocado_api" package.
 * - Prints a message to indicate the application has started running which indicates the APIs are now accepting requests.
 *
 * Annotations:
 * - @SpringBootApplication: Marks this as a Spring Boot application and enables auto-configuration, 
 *   component scanning, and Spring Boot's configuration setup.
**/


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
