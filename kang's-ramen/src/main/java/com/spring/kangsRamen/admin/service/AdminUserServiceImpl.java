package com.spring.kangsRamen.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.kangsRamen.admin.model.dao.AdminUserDao;
import com.spring.kangsRamen.admin.model.dto.SearchDto;
import com.spring.kangsRamen.admin.model.dto.UserDto;

@Service
public class AdminUserServiceImpl implements AdminUserService {

	@Autowired
	private AdminUserDao adminUserDao;

	@Override
	public List<UserDto> getUser(SearchDto searchDto) {
		return adminUserDao.getUser(searchDto);
	}

	@Override
	public List<UserDto> getWithdrawalUser(SearchDto searchDto) {
		return adminUserDao.getWithdrawalUser(searchDto);
	}

}
