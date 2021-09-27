package com.nagarro.service;

import java.util.List;

import com.nagarro.model.Product;
import com.nagarro.repository.ProductRepository;

public class ProductService {
	ProductRepository productRepository = new ProductRepository();

	public List<Product> getAllProducts() {
		List<Product> productList = productRepository.getProducts();

		if (productList == null) {
			System.err.println("Empty List found!");
		}
		return productList;
	}

	public int getProductCount() {
		return productRepository.totalProducts();
	}

	public Product getProduct(int productId) {
		Product product = productRepository.getProduct(productId);
		if (product == null) {
			System.err.println("Product not found!");
		}
		return product;
	}

	public void addProduct(Product product) {
		productRepository.addProduct(product);
	}

	public void updateProduct(Product product) {
		productRepository.updateProduct(product);
	}

	public Product deleteProduct(int productId) {
		Product product = productRepository.deleteProduct(productId);
		return product;
	}
}
