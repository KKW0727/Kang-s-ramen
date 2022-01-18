package com.spring.kangsRamen.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.kangsRamen.model.dto.PaymentDto;
import com.spring.kangsRamen.model.dto.UserDto;
import com.spring.kangsRamen.model.json.ReservationVo;
import com.spring.kangsRamen.service.ReservationService;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;

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

	@RequestMapping(value = "/payment", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> payment(@RequestBody PaymentDto paymentDto) {

		Stripe.apiKey = "sk_test_51K7ZqTJZ9QJfM1Qbsp1OEHxk2zRr9rtMlFONRtzYWGywRyFESIptlPPWgYJKgj7HYLNYBo9K7TgwLOlevERpIt1J00JE56qjDn";

		// Stripeサーバに決済依頼する内容
		Map<String, Object> chargeMap = new HashMap<String, Object>();
		chargeMap.put("amount", 500);
		chargeMap.put("description", "Tシャツ");
		chargeMap.put("currency", "jpy");
		chargeMap.put("source", paymentDto.stripeToken);

		try {
			// 決済依頼
			Charge charge = Charge.create(chargeMap);
		} catch (StripeException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String, Object>>(chargeMap, HttpStatus.OK);
	}
}
