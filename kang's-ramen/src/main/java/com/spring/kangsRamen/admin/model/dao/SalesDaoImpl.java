package com.spring.kangsRamen.admin.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.kangsRamen.admin.model.dto.SalesDto;

@Repository
public class SalesDaoImpl implements SalesDao {

	private static final String NAME_SPACE = "com.spring.kangsRamen.admin.model.dao.SalesDao.";

	@Autowired
	private SqlSession session;

	@Override
	public SalesDto getSales(String date) {
		return session.selectOne(NAME_SPACE + "getSales", date);
	}

}
