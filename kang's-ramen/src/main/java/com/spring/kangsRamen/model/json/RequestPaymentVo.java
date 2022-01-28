package com.spring.kangsRamen.model.json;

public class RequestPaymentVo {

	private String stripeToken;   
	private String stripeTokenType;
	private String stripeEmail;
	private int price;

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
		return "PaymentVo [stripeToken=" + stripeToken + ", stripeTokenType=" + stripeTokenType + ", stripeEmail="
				+ stripeEmail + ", price=" + price + "]";
	}
}
