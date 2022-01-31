package com.spring.kangsRamen.model.json;

public class PaymentVo {

	private int id;
	private int reservation_code;
	private String payment_key;
	private String stripeToken;
	private String stripeTokenType;
	private String stripeEmail;
	private int price;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getReservation_code() {
		return reservation_code;
	}

	public void setReservation_code(int reservation_code) {
		this.reservation_code = reservation_code;
	}

	public String getPayment_key() {
		return payment_key;
	}

	public void setPayment_key(String payment_key) {
		this.payment_key = payment_key;
	}

	public String getStripeToken() {
		return stripeToken;
	}

	public void setStripeToken(String stripeToken) {
		this.stripeToken = stripeToken;
	}

	public String getStripeTokenType() {
		return stripeTokenType;
	}

	public void setStripeTokenType(String stripeTokenType) {
		this.stripeTokenType = stripeTokenType;
	}

	public String getStripeEmail() {
		return stripeEmail;
	}

	public void setStripeEmail(String stripeEmail) {
		this.stripeEmail = stripeEmail;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "PaymentVo [id=" + id + ", reservation_code=" + reservation_code + ", payment_key=" + payment_key
				+ ", stripeToken=" + stripeToken + ", stripeTokenType=" + stripeTokenType + ", stripeEmail="
				+ stripeEmail + ", price=" + price + "]";
	}
}
