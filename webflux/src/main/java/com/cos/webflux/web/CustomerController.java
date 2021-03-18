package com.cos.webflux.web;

import java.time.Duration;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.webflux.domain.Customer;
import com.cos.webflux.domain.CustomerRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
public class CustomerController {
	
	private final CustomerRepository customerRepository;
	
	@PostMapping("/customer")
	public Mono<Customer> save(@RequestBody Customer customer){
		return customerRepository.save(customer).log();
	}
	
	@GetMapping(value = "/customer", produces = MediaType.TEXT_EVENT_STREAM_VALUE) //비동기
	public Flux<Customer> findAll(){
		// 주식 사이트 같이 화면이 지속적으로 변경되는 사이트에 사용!
		return customerRepository.findAll().delayElements(Duration.ofSeconds(1)).log();
	}
	
	@GetMapping(value = "/customer/{id}")
	public Mono<Customer> findById(@PathVariable Long id){
		return customerRepository.findById(id);
	}
	
	@DeleteMapping("/customer/{id}")
	public Mono<Void> deleteById(@PathVariable Long id){
		return customerRepository.deleteById(id);
	}
	
	@PutMapping("/customer/{id}")
	public Mono<Customer> updateById(@PathVariable Long id, @RequestBody Customer customer){
		customer.setId(id);
		
		return customerRepository.save(customer);
	}
}
