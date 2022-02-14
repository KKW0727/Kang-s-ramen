package com.spring.kangsRamen.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.kangsRamen.model.dao.ReservationDao;
import com.spring.kangsRamen.model.json.PaymentVo;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.Refund;

@Service
public class PaymentService {

	@Autowired
	private ReservationDao reservationDao;

	public int payment(PaymentVo paymentVo) {
		Charge charge = null;
		int insertPaymentResult = 0;
		Stripe.apiKey = "sk_test_51K7ZqTJZ9QJfM1Qbsp1OEHxk2zRr9rtMlFONRtzYWGywRyFESIptlPPWgYJKgj7HYLNYBo9K7TgwLOlevERpIt1J00JE56qjDn";

		// Stripeサーバに決済依頼する内容
		Map<String, Object> chargeMap = new HashMap<String, Object>();
		chargeMap.put("amount", paymentVo.getPrice());
		chargeMap.put("description", "ラーメン");
		chargeMap.put("currency", "jpy");
		chargeMap.put("source", paymentVo.getStripeToken());

		try {
			// 決済依頼
			charge = Charge.create(chargeMap);
		} catch (StripeException e) {
			e.printStackTrace();
		}
		// 決済成功
		if (charge.getStatus().equals("succeeded")) {
			paymentVo.setPayment_key(charge.getId());
			insertPaymentResult = reservationDao.insertPayment(paymentVo);
			return insertPaymentResult;
		}
		// 決済失敗
		return insertPaymentResult;
	}

	public int refund(PaymentVo paymentVo) {
		Refund refund = null;
		int deletePaymentResult = 0;
		Stripe.apiKey = "sk_test_51K7ZqTJZ9QJfM1Qbsp1OEHxk2zRr9rtMlFONRtzYWGywRyFESIptlPPWgYJKgj7HYLNYBo9K7TgwLOlevERpIt1J00JE56qjDn";

		// Stripeサーバに決済依頼する内容
		Map<String, Object> chargeMap = new HashMap<String, Object>();

		chargeMap.put("charge", paymentVo.getPayment_key());

		try {
			refund = Refund.create(chargeMap);
		} catch (StripeException e) {
			e.printStackTrace();
		}
		// 返金成功
		if (refund.getStatus().equals("succeeded")) {
			deletePaymentResult = reservationDao.deletePayment(paymentVo.getReservation_code());
			return deletePaymentResult;
		}
		// 返金失敗
		return deletePaymentResult;
	}
}
