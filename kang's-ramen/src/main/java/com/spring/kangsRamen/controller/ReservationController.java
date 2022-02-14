package com.spring.kangsRamen.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.kangsRamen.admin.service.GameInfoService;
import com.spring.kangsRamen.model.dto.UserDto;
import com.spring.kangsRamen.service.ReservationService;

@Controller
public class ReservationController {

	@Autowired
	private ReservationService reservationService;
	@Autowired
	private GameInfoService gameInfoService;

	@RequestMapping(value = "/reservation", method = RequestMethod.GET)
	public String reservation(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		UserDto user = (UserDto) session.getAttribute("login_user");
		if (user == null) {
			return "redirect:/index";
		}
		model.addAttribute("game_info", gameInfoService.getGameInfo());
		return "reservation/reservation";
	}

	@RequestMapping(value = "/reservations", method = RequestMethod.GET)
	public String confirmReservation(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		UserDto user = (UserDto) session.getAttribute("login_user");
		if (user == null) {
			return "redirect:/index";
		}
		model.addAttribute("reservationList", reservationService.getAllReservation(user.getId()));
		return "reservation/confirm_reservation";
	}

	@RequestMapping(value = "/reservations/{reservation_code}", method = RequestMethod.GET)
	public String updateReservation(@PathVariable int reservation_code, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		UserDto user = (UserDto) session.getAttribute("login_user");
		if (user == null) {
			return "redirect:/index";
		}
		model.addAttribute("reservationOne", reservationService.getOneReservation(reservation_code));
		return "reservation/update_reservation";
	}

}