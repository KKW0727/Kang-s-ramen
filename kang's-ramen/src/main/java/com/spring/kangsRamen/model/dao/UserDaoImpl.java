package com.spring.kangsRamen.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.kangsRamen.model.dto.UserDto;
import com.spring.kangsRamen.model.json.SignInVo;
import com.spring.kangsRamen.model.json.SignUpVo;

@Repository
public class UserDaoImpl implements UserDao {

	private static final String NAME_SPACE = "com.spring.ramen.model.dao.UserDao.";

	@Autowired
	private SqlSession session;

	@Override
	public int signUpPhoneCheck(String signUpPhone) {
		return session.selectOne(NAME_SPACE + "signUpPhoneCheck", signUpPhone);
	}

	@Override
	public int signUpEmailCheck(String signUpEmail) {
		return session.selectOne(NAME_SPACE + "signUpEmailCheck", signUpEmail);
	}

	@Override
	public int signUpInsert(SignUpVo signUpVo) {
		return session.insert(NAME_SPACE + "signUpInsert", signUpVo);
	}

	@Override
	public int signIn(SignInVo signInVo) {
		return session.selectOne(NAME_SPACE + "signIn", signInVo);
	}

	@Override
	public UserDto getUser(String signInEmail) {
		return session.selectOne(NAME_SPACE + "getUser", signInEmail);
	}

}
