package com.cos.mybatis1.repository;


import org.apache.ibatis.annotations.Mapper;

import com.cos.mybatis1.model.beans.PanmaeBean;

//인터페이스는 레파지토리에 뜨지 않는다
//@Repository
@Mapper //그래서 매퍼를 사용 (인터페이스를 구현한 객체를 사용)
public interface PanmaeRepository {
	public PanmaeBean findByIdAndJoin(int id);
	
}
