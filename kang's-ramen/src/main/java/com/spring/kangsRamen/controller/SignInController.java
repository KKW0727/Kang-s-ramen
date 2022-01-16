package com.spring.kangsRamen.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.kangsRamen.model.json.SignInVo;
import com.spring.kangsRamen.service.UserService;

@Controller
public class SignInController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/sign-in", method = RequestMethod.GET)
	public String signIn() {
		return "sign_in/sign_in";
	}

	@ResponseBody
	@RequestMapping(value = "/sign-in", method = RequestMethod.POST)
	public String SignIn(@RequestBody SignInVo signInVo, HttpServletRequest request) {
		int signInResult = userService.signIn(signInVo);
		if (signInResult == 2) {
			HttpSession session = request.getSession();
			session.setAttribute("login_user", userService.getUser(signInVo.getSignInEmail()));
		}

		return Integer.toString(signInResult);
	}
}
