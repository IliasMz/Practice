package org.sid.inventoryservice;

import org.sid.inventoryservice.entities.Product;
import org.sid.inventoryservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.List;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}
	@Bean
	 CommandLineRunner start(ProductRepository productRepository,
											   RepositoryRestConfiguration repositoryRestConfiguration) {
		return args -> {
			repositoryRestConfiguration.exposeIdsFor(Product.class);
			productRepository.saveAll(
					List.of(
                            Product.builder().name("Product 1").price(10.0).quantity(100).build(),
                            Product.builder().name("Product 2").price(20.0).quantity(50).build(),
                            Product.builder().name("Product 3").price(30.0).quantity(20).build()
                    )
			);
			productRepository.findAll().forEach(System.out::println);
		};


}
}
