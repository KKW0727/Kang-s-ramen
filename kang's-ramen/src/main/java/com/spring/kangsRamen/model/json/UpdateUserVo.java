package com.spring.kangsRamen.model.json;

public class UpdateUserVo {

	private int id;
	private String updateUserPassword;
	private String updateUserPhone;
	private String updateUserBirthday;
	private int updateUserFlag;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUpdateUserPassword() {
		return updateUserPassword;
	}

	public void setUpdateUserPassword(String updateUserPassword) {
		this.updateUserPassword = updateUserPassword;
	}

	public String getUpdateUserPhone() {
		return updateUserPhone;
	}

	public void setUpdateUserPhone(String updateUserPhone) {
		this.updateUserPhone = updateUserPhone;
	}

	public String getUpdateUserBirthday() {
		return updateUserBirthday;
	}

	public void setUpdateUserBirthday(String updateUserBirthday) {
		this.updateUserBirthday = updateUserBirthday;
	}

	public int getUpdateUserFlag() {
		return updateUserFlag;
	}

	public void setUpdateUserFlag(int updateUserFlag) {
		this.updateUserFlag = updateUserFlag;
	}

	@Override
	public String toString() {
		return "UpdateUserVo [id=" + id + ", updateUserPassword=" + updateUserPassword + ", updateUserPhone="
				+ updateUserPhone + ", updateUserBirthday=" + updateUserBirthday + ", updateUserFlag=" + updateUserFlag
				+ "]";
	}

}
