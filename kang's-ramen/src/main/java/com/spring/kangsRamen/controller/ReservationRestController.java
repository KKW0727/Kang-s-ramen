package com.spring.kangsRamen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import com.spring.kangsRamen.model.json.ReservationVo;
import com.spring.kangsRamen.service.ReservationService;

@RestController
@RequestMapping("/reservations")
public class ReservationRestController {

	@Autowired
	private ReservationService reservationService;

	@RequestMapping(method = RequestMethod.POST)
	public String reservation(@RequestBody ReservationVo reservationVo) {
		return Integer.toString(reservationService.InsertReservation(reservationVo));
	}

	@RequestMapping(value = "/{reservation_code}", method = RequestMethod.PUT)
	public String updateReservation(@RequestBody ReservationVo reservationVo) {
		return Integer.toString(reservationService.updateReservation(reservationVo));
	}

	@RequestMapping(value = "/{reservation_code}", method = RequestMethod.DELETE)
	public String deleteReservation(@PathVariable int reservation_code) {
		return Integer.toString(reservationService.deleteReservation(reservation_code));

	}

}
