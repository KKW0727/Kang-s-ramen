package com.spring.kangsRamen.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.kangsRamen.admin.model.dto.SearchDto;
import com.spring.kangsRamen.admin.service.AdminReservationService;

@Controller
public class AdminReservationController {

	@Autowired
	private AdminReservationService adminReservationService;

	@ResponseBody
	@RequestMapping(value = "/reservations/{searchType}/{searchContent}", method = RequestMethod.GET)
	public Object getReservation(SearchDto searchDto) {
		return adminReservationService.getReservation(searchDto);
	}

	@ResponseBody
	@RequestMapping(value = "/cancel-reservation/{searchType}/{searchContent}", method = RequestMethod.GET)
	public Object getCanceledReservation(SearchDto searchDto) {
		return adminReservationService.getCanceledReservation(searchDto);
	}
}
