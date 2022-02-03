package com.spring.kangsRamen.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.kangsRamen.model.dto.UserDto;
import com.spring.kangsRamen.model.json.SignInVo;
import com.spring.kangsRamen.service.ReservationService;
import com.spring.kangsRamen.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private ReservationService reservationService;

	@RequestMapping(value = "/registry", method = RequestMethod.GET)
	public String signUp() {
		return "sign_up/sign_up";
	}

	@ResponseBody
	@RequestMapping(value = "/registry/phone-check", method = RequestMethod.POST)
	public String signUpPhoneCheck(@RequestParam String signUpPhone) {
		System.out.println(signUpPhone);
		return Integer.toString(userService.signUpPhoneCheck(signUpPhone));
	}

	@ResponseBody
	@RequestMapping(value = "/registry/email-check", method = RequestMethod.POST)
	public String signUpEmailCheck(@RequestParam String signUpEmail) {
		System.out.println(signUpEmail);
		return Integer.toString(userService.signUpEmailCheck(signUpEmail));
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String signIn() {
		return "sign_in/sign_in";
	}

	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String SignIn(@RequestBody SignInVo signInVo, HttpServletRequest request) {
		int signInResult = userService.signIn(signInVo);
		if (signInResult == 2) {
			HttpSession session = request.getSession();
			session.setAttribute("login_user", userService.getUser(signInVo.getSignInEmail()));
		}
		return Integer.toString(signInResult);
	}

	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	public String mypage(Model model, @PathVariable int id, HttpServletRequest request) {
		HttpSession session = request.getSession();
		UserDto user = (UserDto) session.getAttribute("login_user");
		if (user == null) {
			return "redirect:/index";
		}
		model.addAttribute("canceledReservationList", reservationService.getAllCanceledReservation(id));
		return "mypage/mypage";
	}

	@ResponseBody
	@RequestMapping(value = "/logout", method = RequestMethod.DELETE)
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "1";
	}
}
