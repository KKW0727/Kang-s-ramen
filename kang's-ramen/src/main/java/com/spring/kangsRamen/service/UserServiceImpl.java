package com.spring.kangsRamen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.kangsRamen.model.dao.UserDao;
import com.spring.kangsRamen.model.json.SignUpVo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public int signUpPhoneCheck(String signUpPhone) {
		return userDao.signUpPhoneCheck(signUpPhone);
	}

	@Override
	public int signUpEmailCheck(String signUpEmail) {
		return userDao.signUpEmailCheck(signUpEmail);
	}

	@Override
	public int signUpInsert(SignUpVo signUpVo) {
		return userDao.signUpInsert(signUpVo);
	}
}
