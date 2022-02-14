package com.spring.kangsRamen.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.kangsRamen.admin.model.dao.SalesDao;
import com.spring.kangsRamen.admin.model.dto.SalesDto;

@Service
public class SalesServiceImpl implements SalesService {

	@Autowired
	private SalesDao salesDao;

	@Override
	public SalesDto getSales(String date) {
		return salesDao.getSales(date);
	}

}
