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
import com.cos.mybatis1.model.beans.PanmaeBean;
import com.cos.mybatis1.repository.PanmaeRepository;
import com.cos.mybatis1.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class PanmaeController {
	private final PanmaeRepository panmaeRepository;
	
	@GetMapping("/panmae/{id}")
	public PanmaeBean findByIdAndJoin(@PathVariable int id) {
		
		return panmaeRepository.findByIdAndJoin(id);
	}
	
	
}
