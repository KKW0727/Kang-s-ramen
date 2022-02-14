package com.spring.kangsRamen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.kangsRamen.model.json.PaymentVo;
import com.spring.kangsRamen.service.PaymentService;

@RestController
public class PaymentRestController {

//	@Autowired
//	private ReservationService reservationService;
	@Autowired
	private PaymentService paymentService;

	@RequestMapping(value = "/payment", method = RequestMethod.POST)
	public String payment(@RequestBody PaymentVo paymentVo) {
		return Integer.toString(paymentService.payment(paymentVo));
	}

	@RequestMapping(value = "/refund", method = RequestMethod.POST)
	public String refund(@RequestBody PaymentVo paymentVo) {
		return Integer.toString(paymentService.refund(paymentVo));
	}
}
