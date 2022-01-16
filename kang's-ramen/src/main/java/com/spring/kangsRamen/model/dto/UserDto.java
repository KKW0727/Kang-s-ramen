package com.spring.kangsRamen.model.dto;

import java.time.LocalDate;

public class UserDto {

	private int id;
	private String user_email;
	private String user_password;
	private String user_phone;
	private String user_birthday;
	private String user_gender;
	private LocalDate create_date;
	private LocalDate update_date;

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

	public LocalDate getCreate_date() {
		return create_date;
	}

	public void setCreate_date(LocalDate create_date) {
		this.create_date = create_date;
	}

	public LocalDate getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(LocalDate update_date) {
		this.update_date = update_date;
	}

	@Override
	public String toString() {
		return "UserDto [id=" + id + ", user_email=" + user_email + ", user_password=" + user_password + ", user_phone="
				+ user_phone + ", user_birthday=" + user_birthday + ", user_gender=" + user_gender + ", create_date="
				+ create_date + ", update_date=" + update_date + "]";
	}
}
