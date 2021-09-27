package com.nagarro.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.nagarro.model.Product;
import com.nagarro.service.ProductService;

@CrossOrigin("*")	
@Path("/")
@Consumes({ MediaType.APPLICATION_FORM_URLENCODED, MediaType.APPLICATION_JSON })
@Produces(MediaType.APPLICATION_JSON)
public class ProductController {
	private ProductService productService = new ProductService();

	@GET
	@Path("/products")
	public List<Product> getProducts() {
		List<Product> products = productService.getAllProducts();
		return products;
	}

	@GET
	@Path("/products/count")
	public int getTotalProducts() {
		return productService.getProductCount();
	}

	@GET
	@Path("/products/{productId}")
	public Product getProduct(@PathParam("productId") int productId) {
		Product product = productService.getProduct(productId);
		return product;
	}

	@POST
	@Path("/products")
	public Product addProduct(Product product) {
		productService.addProduct(product);
		return product;
	}

	@PUT
	@Path("/products")
	public Product updateProduct(Product product) {
		productService.updateProduct(product);
		return product;
	}

	@DELETE
	@Path("/products/{productId}")
	public Product deleteProduct(@PathParam("productId") int productId) {
		Product product = productService.deleteProduct(productId);
		return product;
	}
}
