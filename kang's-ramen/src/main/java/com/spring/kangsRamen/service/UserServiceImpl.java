package com.spring.kangsRamen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.kangsRamen.model.dao.UserDao;
import com.spring.kangsRamen.model.dto.UserDto;
import com.spring.kangsRamen.model.json.SignInVo;
import com.spring.kangsRamen.model.json.SignUpVo;
import com.spring.kangsRamen.model.json.UpdateUserVo;

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

	@Override
	public int signIn(SignInVo signInVo) {
		return userDao.signIn(signInVo);
	}

	@Override
	public UserDto getUser(String signInEmail) {
		return userDao.getUser(signInEmail);
	}
	
	@Override
	public int updateUser(UpdateUserVo updateUserVo) {
		int updateResult = 0;
		if(updateUserVo.getUpdateUserFlag() == 1) {
			updateResult = userDao.updateUserPhone(updateUserVo);
		}else if(updateUserVo.getUpdateUserFlag() == 2) {
			updateResult = userDao.updateUserPassword(updateUserVo);
		}else if(updateUserVo.getUpdateUserFlag() == 3) {
			updateResult = userDao.updateUserBirthday(updateUserVo);
		}
		return updateResult;
	}
}
