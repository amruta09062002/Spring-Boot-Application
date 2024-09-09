package com.example.ProductManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ProductManagement.entity.Product;
import com.example.ProductManagement.service.ProductService;


@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping("/insert")
	public String insertProduct(@RequestBody Product product) {
		return productService.insertProduct(product);
	}
	
	@PutMapping("/update-product-by-id/{id}")
	public String updateProduct(@PathVariable Long id, @RequestBody Product product) {
		return productService.updateProduct(id, product);
	}
	
	@GetMapping("/product/500")
	public List<Product> priceGreaterThan() {
		return productService.priceGreaterThan();
	}
	
	@GetMapping("/{id}/sales")
	public int getSales(@PathVariable long id) {
		return productService.getSales(id);
	}
	
	@GetMapping("/top-expensive/{n}")
	public List<Product> topExpensive(@PathVariable int n) {
		return productService.topExpensive(n);
	}
}
