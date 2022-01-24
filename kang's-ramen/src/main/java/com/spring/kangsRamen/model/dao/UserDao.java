package com.spring.kangsRamen.model.dao;

import com.spring.kangsRamen.model.dto.UserDto;
import com.spring.kangsRamen.model.json.SignInVo;
import com.spring.kangsRamen.model.json.SignUpVo;
import com.spring.kangsRamen.model.json.UpdateUserVo;

public interface UserDao {

	public int signUpPhoneCheck(String signUpPhone);
	public int signUpEmailCheck(String signUpEmail);
	public int signUpInsert(SignUpVo signUpVo);
	public int signIn(SignInVo signInVo);
	public UserDto getUser(String signInEmail);
	public int updateUserPhone(UpdateUserVo updateUserVo);
	public int updateUserPassword(UpdateUserVo updateUserVo);
	public int updateUserBirthday(UpdateUserVo updateUserVo);
	public int withdraw(int id);
}
