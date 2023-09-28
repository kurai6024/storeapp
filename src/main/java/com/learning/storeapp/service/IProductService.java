package com.learning.storeapp.service;

import java.util.List;

import com.learning.storeapp.domain.Product;

public interface IProductService {

	public Product addProduct(Product product);

	public Product updateProduct(Product product);

	public List<Product> getAllProducts();

	public Product getProductById(Integer id);

	public void deleteProductById(Integer id);

	public List<Product> findByName(String name);

	public List<Product> findByBrand(String brand);

	public List<Product> findByPrice(double price);

}
