package com.spring.kangsRamen.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.kangsRamen.model.dto.UserDto;
import com.spring.kangsRamen.model.json.ReservationVo;
import com.spring.kangsRamen.service.ReservationService;

@Controller
public class ReservationController {

	@Autowired
	private ReservationService reservationService;

	@RequestMapping(value = "/reservation", method = RequestMethod.GET)
	public String reservation(@RequestParam int game_result, Model model, HttpServletRequest request) {
		model.addAttribute("game_result", game_result);
		HttpSession session = request.getSession();
		UserDto user = (UserDto) session.getAttribute("login_user");
		if (user == null) {
			return "redirect:index";
		}
		return "reservation/reservation";
	}

	@ResponseBody
	@RequestMapping(value = "/reservation", method = RequestMethod.POST)
	public String reservation(@RequestBody ReservationVo reservationVo) {
		return Integer.toString(reservationService.InsertReservation(reservationVo));
	}

	@ResponseBody
	@RequestMapping(value = "/update-payment", method = RequestMethod.PUT)
	public String updatePayment(@RequestParam int reservation_code) {
		return Integer.toString(reservationService.updatePayment(reservation_code));
	}

	@RequestMapping(value = "/update-reservation", method = RequestMethod.GET)
	public ModelAndView updateReservation(@RequestParam int reservation_code) {
		ModelAndView mav = new ModelAndView("reservation/update_reservation");
		mav.addObject("reservationOne", reservationService.getOneReservation(reservation_code));
		return mav;
	}

	@ResponseBody
	@RequestMapping(value = "/update-reservation", method = RequestMethod.PUT)
	public String updateReservation(@RequestBody ReservationVo reservationVo) {
		return Integer.toString(reservationService.updateReservation(reservationVo));
	}

}