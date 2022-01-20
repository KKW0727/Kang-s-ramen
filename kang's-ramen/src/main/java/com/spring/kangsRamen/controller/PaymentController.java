package com.spring.kangsRamen.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.kangsRamen.model.json.PaymentVo;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;

@Controller
public class PaymentController {

	@RequestMapping(value = "/payment", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> payment(@RequestBody PaymentVo paymentVo) {
		System.out.println(paymentVo);
		Stripe.apiKey = "sk_test_51K7ZqTJZ9QJfM1Qbsp1OEHxk2zRr9rtMlFONRtzYWGywRyFESIptlPPWgYJKgj7HYLNYBo9K7TgwLOlevERpIt1J00JE56qjDn";

		// Stripeサーバに決済依頼する内容
		Map<String, Object> chargeMap = new HashMap<String, Object>();
		chargeMap.put("amount", paymentVo.getPrice());
		chargeMap.put("description", "ラーメン");
		chargeMap.put("currency", "jpy");
		chargeMap.put("source", paymentVo.getStripeToken());

		try {
			// 決済依頼
			Charge charge = Charge.create(chargeMap);
		} catch (StripeException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String, Object>>(chargeMap, HttpStatus.OK);
	}
}
