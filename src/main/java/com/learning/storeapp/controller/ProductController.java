package com.learning.storeapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.learning.storeapp.domain.Product;
import com.learning.storeapp.service.IProductService;

@RestController
@Scope(value = "request")
public class ProductController {

	@Autowired
	@Qualifier("productService")
	private IProductService productService;

	@PostMapping(value = "/products", produces = {MediaType.APPLICATION_JSON_VALUE},
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.CREATED)
	public Product addProduct(@RequestBody Product product) {
		
		return productService.addProduct(product);
	}
	
	@PutMapping(value = "/products", produces = {MediaType.APPLICATION_JSON_VALUE},
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.OK)
	public Product updateProduct(@RequestBody Product product) {
		
		return productService.updateProduct(product);
	}
	
	@DeleteMapping(value = "/products/{id}", produces = {MediaType.APPLICATION_JSON_VALUE}, 
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteProductById(@PathVariable("id") Integer id) {
		productService.deleteProductById(id);
	}
	
	@GetMapping(value = "/products/{id}", produces = {MediaType.APPLICATION_JSON_VALUE}, 
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	public Product getProductById(@PathVariable("id") Integer id) {
		return productService.getProductById(id);
	}
	
	@GetMapping(value = "/products", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}
	
	@GetMapping(value = "/products/name/{name}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Product> getAllProductsByName(@PathVariable("name") String name) {
		return productService.findByName(name);
	}
	
	@GetMapping(value = "/products/brand/{brand}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Product> getAllProductsByBrand(@PathVariable("brand") String brand) {
		return productService.findByBrand(brand);
	}
	
	@GetMapping(value = "/products/price/{price}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Product> getAllProductsByPrice(@PathVariable("price") double price) {
		return productService.findByPrice(price);
	}
}
