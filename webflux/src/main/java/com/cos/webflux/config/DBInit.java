package com.cos.webflux.config;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.r2dbc.connectionfactory.init.ConnectionFactoryInitializer;
import org.springframework.data.r2dbc.connectionfactory.init.ResourceDatabasePopulator;

import com.cos.webflux.domain.Customer;
import com.cos.webflux.domain.CustomerRepository;

import io.r2dbc.spi.ConnectionFactory;



@Configuration
public class DBInit {
	
	
	@Bean
	public ConnectionFactoryInitializer dbInit(ConnectionFactory connectionFactory) {
		ConnectionFactoryInitializer init = new ConnectionFactoryInitializer();
		init.setConnectionFactory(connectionFactory);
		init.setDatabasePopulator(new ResourceDatabasePopulator (new ClassPathResource("schema.sql")));
		
		return init;
	}
	
	@Bean //리턴값을 IoC에 등록 그게 CommandLineRunner타입이면 그냥 스프링 내부에서 실행시켜 버림! (초기화 용)
	public CommandLineRunner dataInit(CustomerRepository customerRepository) { // customerRepository이게 이미 IoC에 등록되어 있어서 동작함 
		return (args) -> {
			// 데이터 초기화 하기
			customerRepository.saveAll(Arrays.asList(
					new Customer("Jack","Bauer"),
					new Customer("Choi","Bauer"),
					new Customer("Hong","Bauer"),
					new Customer("Han","Bauer"),
					new Customer("Joker","Bauer"))).blockLast();
		};
	}
}
