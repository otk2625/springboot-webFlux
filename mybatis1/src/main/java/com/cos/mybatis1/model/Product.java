package com.cos.mybatis1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@Data
public class Product {
	private int id;
	private String name; //상품명
	private String code; //상품코드
}
