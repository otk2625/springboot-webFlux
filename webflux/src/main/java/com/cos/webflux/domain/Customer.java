package com.cos.webflux.domain;

import org.springframework.data.annotation.Id; //Nosql에서 사용

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Customer {
	
	@Id
	private Long id;
	private final String firstName;
	private final String lastName;
	
	
}	
