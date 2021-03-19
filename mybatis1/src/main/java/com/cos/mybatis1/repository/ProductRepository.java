package com.cos.mybatis1.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.cos.mybatis1.model.Product;

//인터페이스는 레파지토리에 뜨지 않는다
//@Repository
@Mapper //그래서 매퍼를 사용 (인터페이스를 구현한 객체를 사용)
public interface ProductRepository {
	public void save(Product product);
	
	public void delete(int id);

	public void update(Product product);
	
	public List<Product> findAll(int page);
	
	public Product findById(int id);
}
