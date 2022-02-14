package com.spring.kangsRamen.admin.model.dto;

public class SalesDto {

	private int total_reservation;
	private int total_karaiRamen;
	private int total_shoyu;
	private int total_miso;
	private int total_tonkotsu;
	private int total_price;

	public int getTotal_reservation() {
		return total_reservation;
	}

	public void setTotal_reservation(int total_reservation) {
		this.total_reservation = total_reservation;
	}

	public int getTotal_karaiRamen() {
		return total_karaiRamen;
	}

	public void setTotal_karaiRamen(int total_karaiRamen) {
		this.total_karaiRamen = total_karaiRamen;
	}

	public int getTotal_shoyu() {
		return total_shoyu;
	}

	public void setTotal_shoyu(int total_shoyu) {
		this.total_shoyu = total_shoyu;
	}

	public int getTotal_miso() {
		return total_miso;
	}

	public void setTotal_miso(int total_miso) {
		this.total_miso = total_miso;
	}

	public int getTotal_tonkotsu() {
		return total_tonkotsu;
	}

	public void setTotal_tonkotsu(int total_tonkotsu) {
		this.total_tonkotsu = total_tonkotsu;
	}

	public int getTotal_price() {
		return total_price;
	}

	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}

	@Override
	public String toString() {
		return "SalesDto [total_reservation=" + total_reservation + ", total_karaiRamen=" + total_karaiRamen
				+ ", total_shoyu=" + total_shoyu + ", total_miso=" + total_miso + ", total_tonkotsu=" + total_tonkotsu
				+ ", total_price=" + total_price + "]";
	}

}
