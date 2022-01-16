package com.spring.kangsRamen.model.json;

public class SignInVo {

	private String signInEmail;
	private String signInPassword;

	public String getSignInEmail() {
		return signInEmail;
	}

	public void setSignInEmail(String signInEmail) {
		this.signInEmail = signInEmail;
	}

	public String getSignInPassword() {
		return signInPassword;
	}

	public void setSignInPassword(String signInPassword) {
		this.signInPassword = signInPassword;
	}

	@Override
	public String toString() {
		return "SignInVo [signInEmail=" + signInEmail + ", signInPassword=" + signInPassword + "]";
	}
}
