package com.spring.kangsRamen.model.json;

public class SignUpVo {

	private String signUpEmail;
	private String signUpPassword;
	private String signUpPhone;
	private String signUpBirthday;
	private String signUpGender;

	public String getSignUpEmail() {
		return signUpEmail;
	}

	public void setSignUpEmail(String signUpEmail) {
		this.signUpEmail = signUpEmail;
	}

	public String getSignUpPassword() {
		return signUpPassword;
	}

	public void setSignUpPassword(String signUpPassword) {
		this.signUpPassword = signUpPassword;
	}

	public String getSignUpPhone() {
		return signUpPhone;
	}

	public void setSignUpPhone(String signUpPhone) {
		this.signUpPhone = signUpPhone;
	}

	public String getSignUpBirthday() {
		return signUpBirthday;
	}

	public void setSignUpBirthday(String signUpBirthday) {
		this.signUpBirthday = signUpBirthday;
	}

	public String getSignUpGender() {
		return signUpGender;
	}

	public void setSignUpGender(String signUpGender) {
		this.signUpGender = signUpGender;
	}

	@Override
	public String toString() {
		return "SignUpVo [signUpEmail=" + signUpEmail + ", signUpPassword=" + signUpPassword + ", signUpPhone="
				+ signUpPhone + ", signUpBirthday=" + signUpBirthday + ", signUpGender=" + signUpGender + "]";
	}

}
