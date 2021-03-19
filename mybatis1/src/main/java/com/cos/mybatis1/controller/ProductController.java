package com.cos.mybatis1.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.mybatis1.model.Product;
import com.cos.mybatis1.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class ProductController {
	private final ProductRepository productRepository;
	
	@GetMapping("/product")
	public List<Product> findAll() {
		productRepository.findAll(0);
		return productRepository.findAll(0);
	}
	
	@GetMapping("/product/{id}")
	public Product findById(@PathVariable int id) {
		return productRepository.findById(id);
	}
	
	@PostMapping("/product")
	public String save(@RequestBody Product product) {
		productRepository.save(product);
		return "ok";
	}
	
	@DeleteMapping("/product/{id}")
	public String delete(@PathVariable int id) {
		productRepository.delete(id);
		return "삭제";
	}
	
	@PutMapping("/product/{id}")
	public String update(@PathVariable int id, @RequestBody Product product) {
		product.setId(id);
		productRepository.update(product);
		
		return "수정";
	}
}
