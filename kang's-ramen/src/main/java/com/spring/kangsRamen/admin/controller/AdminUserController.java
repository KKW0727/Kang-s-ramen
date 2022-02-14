package com.spring.kangsRamen.admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.kangsRamen.admin.model.dto.SearchDto;
import com.spring.kangsRamen.admin.service.AdminUserService;
import com.spring.kangsRamen.model.dto.UserDto;

@Controller
public class AdminUserController {

	@Autowired
	private AdminUserService adminUserService;

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String admin(HttpServletRequest request) {
		HttpSession session = request.getSession();
		UserDto user = (UserDto) session.getAttribute("login_user");
		if (user == null || !user.getUser_email().equals("gig2010@naver.com")) {
			return "redirect:index";
		}
		return "admin/admin";
	}

	@ResponseBody
	@RequestMapping(value = "/user/{searchType}/{searchContent}", method = RequestMethod.GET)
	public Object getUser(SearchDto searchDto) {
		return adminUserService.getUser(searchDto);
	}

	@ResponseBody
	@RequestMapping(value = "/withdrawal-user/{searchType}/{searchContent}", method = RequestMethod.GET)
	public Object getwithdrawalUser(SearchDto searchDto) {
		return adminUserService.getWithdrawalUser(searchDto);
	}

}