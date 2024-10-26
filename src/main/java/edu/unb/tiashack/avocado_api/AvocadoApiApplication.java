package edu.unb.tiashack.avocado_api;

import edu.unb.tiashack.avocado_api.model.AvocadoSale;
import edu.unb.tiashack.avocado_api.repository.AvocadoSaleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@SpringBootApplication
public class AvocadoApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AvocadoApiApplication.class, args);
	}

	// temporary: just testing repository
	@Bean
	public CommandLineRunner demo(AvocadoSaleRepository avocadoSaleRepository) {
		return (args) -> {
			try {
				List<AvocadoSale> allAvocadoSales = avocadoSaleRepository.findAll();
				System.out.println("All Avocado Sales Data: ");
				allAvocadoSales.forEach(System.out::println);
			} catch (Exception e) {
				System.err.println("Error retrieving avocado sales: " + e.getMessage());
			}
		};
	}
}
