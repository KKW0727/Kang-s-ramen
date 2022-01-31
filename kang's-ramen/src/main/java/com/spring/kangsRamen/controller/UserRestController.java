package com.spring.kangsRamen.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.kangsRamen.model.dto.UserDto;
import com.spring.kangsRamen.model.json.SignUpVo;
import com.spring.kangsRamen.model.json.UpdateUserVo;
import com.spring.kangsRamen.service.UserService;

@RestController
@RequestMapping("/users")
public class UserRestController {

	@Autowired
	private UserService userService;

	@ResponseBody
	@RequestMapping(method = RequestMethod.POST)
	public String signUpInsert(@RequestBody SignUpVo signUpVo) {
		return Integer.toString(userService.signUpInsert(signUpVo));
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public String updateUser(@RequestBody UpdateUserVo updateUserVo, HttpServletRequest request) {
		int updateUserResult = userService.updateUser(updateUserVo);
		if (updateUserResult == 1) {
			HttpSession session = request.getSession();
			UserDto user = (UserDto) session.getAttribute("login_user");
			session.setAttribute("login_user", userService.getUser(user.getUser_email()));
		}
		return Integer.toString(updateUserResult);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String withdraw(@PathVariable int id, HttpServletRequest request) {
		int withdrawResult = 0;
		withdrawResult = userService.withdraw(id);
		if (withdrawResult == 1) {
			HttpSession session = request.getSession();
			session.invalidate();
			return Integer.toString(withdrawResult);
		}
		return Integer.toString(withdrawResult);
	}

}
