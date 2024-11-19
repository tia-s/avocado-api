package edu.unb.tiashack.avocado_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "edu.unb.tiashack.avocado_api")
public class AvocadoApiApplication {

	public static void main(String[] args) {
		System.out.println("Running API...");

		// Create the CXF bus
//		Bus bus = new SpringBus();
//
//		// Publish the SOAP service
//		String baseUrl = "http://localhost:8080/soap-api";
//		EndpointImpl endpoint = new EndpointImpl(bus, new HelloServiceImpl());
//		endpoint.publish("/hello");
//
//
//		System.out.println("SOAP API is running at: " + baseUrl + "/hello?wsdl");

		SpringApplication.run(AvocadoApiApplication.class, args);

	}



}
