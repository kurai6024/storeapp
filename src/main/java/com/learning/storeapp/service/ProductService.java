package com.learning.storeapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.learning.storeapp.domain.Product;
import com.learning.storeapp.repository.ProductRepository;

@Service(value = "productService")
@Scope(value = "singleton")
public class ProductService implements IProductService {

	@Autowired
	@Qualifier("productRepository")
	private ProductRepository productRepository;

	@Override
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product updateProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product getProductById(Integer id) {
		return productRepository.findById(id).get();
	}

	@Override
	public void deleteProductById(Integer id) {
		productRepository.deleteById(id);
	}

	@Override
	public List<Product> findByName(String name) {
		return productRepository.findByName(name);
	}

	@Override
	public List<Product> findByBrand(String brand) {
		return productRepository.findByBrand(brand);
	}

	@Override
	public List<Product> findByPrice(double price) {
		return productRepository.findByPrice(price);
	}
	
}
