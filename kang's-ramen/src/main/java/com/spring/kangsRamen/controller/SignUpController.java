package com.spring.kangsRamen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.kangsRamen.model.json.SignUpVo;
import com.spring.kangsRamen.service.UserService;

@Controller
public class SignUpController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/sign-up", method = RequestMethod.GET)
	public String signUp() {
		return "sign_up/sign_up";
	}

	@ResponseBody
	@RequestMapping(value = "/sign-up-phoneCheck", method = RequestMethod.POST)
	public String signUpPhoneCheck(@RequestParam String signUpPhone) {
		return Integer.toString(userService.signUpPhoneCheck(signUpPhone));
	}

	@ResponseBody
	@RequestMapping(value = "/sign-up-emailCheck", method = RequestMethod.POST)
	public String signUpEmailCheck(@RequestParam String signUpEmail) {
		return Integer.toString(userService.signUpEmailCheck(signUpEmail));
	}

	@ResponseBody
	@RequestMapping(value = "/sign-up", method = RequestMethod.POST)
	public String signUpInsert(@RequestBody SignUpVo signUpVo) {
		return Integer.toString(userService.signUpInsert(signUpVo));
	}
}
