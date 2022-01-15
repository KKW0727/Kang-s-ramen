package com.spring.kangsRamen.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

}
