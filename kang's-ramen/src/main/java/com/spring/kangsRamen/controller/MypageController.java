package com.spring.kangsRamen.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.kangsRamen.model.dto.UserDto;
import com.spring.kangsRamen.model.json.UpdateUserVo;
import com.spring.kangsRamen.service.ReservationService;
import com.spring.kangsRamen.service.UserService;

@Controller
public class MypageController {

	@Autowired
	private UserService userService;
	@Autowired
	private ReservationService reservationService;

	@RequestMapping(value = "/mypage", method = RequestMethod.GET)
	public String mypage(HttpServletRequest request) {
		HttpSession session = request.getSession();
		UserDto user = (UserDto) session.getAttribute("login_user");
		if (user == null) {
			return "redirect:/index";
		}
		return "mypage/mypage";
	}

	@ResponseBody
	@RequestMapping(value = "/update-user", method = RequestMethod.PUT)
	public String updateUser(@RequestBody UpdateUserVo updateUserVo, HttpServletRequest request) {
		int updateUserResult = userService.updateUser(updateUserVo);
		if (updateUserResult == 1) {
			HttpSession session = request.getSession();
			UserDto user = (UserDto) session.getAttribute("login_user");
			session.setAttribute("login_user", userService.getUser(user.getUser_email()));
		}
		return Integer.toString(updateUserResult);
	}

	@ResponseBody
	@RequestMapping(value = "get-number-reservation/{id}", method = RequestMethod.GET)
	public String getNumberReservation(@PathVariable int id) {
		return Integer.toString(reservationService.getAllReservation(id).size());
	}

	@ResponseBody
	@RequestMapping(value = "withdraw/{id}", method = RequestMethod.DELETE)
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
