package com.spring.kangsRamen.model.json;

public class InsertPaymentVo {

	private int id;
	private int reservation_code;
	private String payment_key;

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

	@Override
	public String toString() {
		return "InsertPaymentVo [id=" + id + ", reservation_code=" + reservation_code + ", payment_key=" + payment_key
				+ "]";
	}

}
