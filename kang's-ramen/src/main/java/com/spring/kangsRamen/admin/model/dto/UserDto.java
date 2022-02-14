package com.spring.kangsRamen.admin.model.dto;

import java.time.LocalDate;

public class UserDto {

	private int id;
	private String user_email;
	private String user_password;
	private String user_phone;
	private String user_birthday;
	private String user_gender;
	private LocalDate user_date;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	public String getUser_birthday() {
		return user_birthday;
	}

	public void setUser_birthday(String user_birthday) {
		this.user_birthday = user_birthday;
	}

	public String getUser_gender() {
		return user_gender;
	}

	public void setUser_gender(String user_gender) {
		this.user_gender = user_gender;
	}

	public String getUser_date() {
		return user_date.toString();
	}

	public void setUser_date(LocalDate create_date) {
		this.user_date = create_date;
	}

	@Override
	public String toString() {
		return "UserDto [id=" + id + ", user_email=" + user_email + ", user_password=" + user_password + ", user_phone="
				+ user_phone + ", user_birthday=" + user_birthday + ", user_gender=" + user_gender + ", create_date="
				+ user_date + "]";
	}
}