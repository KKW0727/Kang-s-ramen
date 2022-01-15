package com.spring.kangsRamen.model.dao;

import com.spring.kangsRamen.model.json.SignUpVo;

public interface UserDao {

	public int signUpPhoneCheck(String signUpPhone);
	public int signUpEmailCheck(String signUpEmail);
	public int signUpInsert(SignUpVo signUpVo);

}
