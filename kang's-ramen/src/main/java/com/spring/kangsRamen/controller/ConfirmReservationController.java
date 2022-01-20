package com.spring.kangsRamen.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.kangsRamen.model.dto.UserDto;
import com.spring.kangsRamen.service.ReservationService;

@Controller
public class ConfirmReservationController {

	@Autowired
	private ReservationService reservationService;

	@RequestMapping(value = "/confirm-reservation", method = RequestMethod.GET)
	public ModelAndView confirmReservation(HttpServletRequest request) {

		HttpSession session = request.getSession();
		UserDto user = (UserDto) session.getAttribute("login_user");

		ModelAndView mav = new ModelAndView("reservation/confirm_reservation");
		mav.addObject("reservationList", reservationService.getAllReservation(user.getId()));
		return mav;
	}
}
