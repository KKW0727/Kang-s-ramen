package com.spring.kangsRamen.admin.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.kangsRamen.admin.model.dto.SearchDto;
import com.spring.kangsRamen.admin.model.dto.UserDto;

@Repository
public class AdminUserDaoImpl implements AdminUserDao {

	private static final String NAME_SPACE = "com.spring.kangsRamen.admin.model.dao.AdminUserDao.";

	@Autowired
	private SqlSession session;

	@Override
	public List<UserDto> getUser(SearchDto searchDto) {
		return session.selectList(NAME_SPACE + "getUser", searchDto);
	}

	@Override
	public List<UserDto> getWithdrawalUser(SearchDto searchDto) {
		return session.selectList(NAME_SPACE + "getWithdrawalUser", searchDto);
	}
}