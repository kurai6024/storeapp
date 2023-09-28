package com.learning.storeapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.learning.storeapp.domain.Product;
import com.learning.storeapp.repository.ProductRepository;

@SpringBootApplication
public class StoreappApplication implements CommandLineRunner { 


	@Autowired
	@Qualifier(value = "productRepository")
	private ProductRepository productRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(StoreappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		productRepository.save(new Product(null, "TV", "LG", 75000.90));
		productRepository.save(new Product(null, "Monitor", "DELL", 24341.57));
		productRepository.save(new Product(null, "EarBuds", "SAMSUNG", 18000.00));
		productRepository.save(new Product(null, "Mobile", "OnePlus11R", 45000.50));
		productRepository.save(new Product(null, "TV", "ONIDA", 175000.90));

		
	}

}
