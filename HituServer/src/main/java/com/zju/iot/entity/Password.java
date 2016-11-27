package com.zju.iot.entity;

import java.util.Date;
/**
 * 密码
 * @author Amei
 */
public class Password {
	private String  passwordID;
	private String password;
	private Date updateDate;
	
	public String getPasswordID() {
		return passwordID;
	}
	public void setPasswordID(String passwordID) {
		this.passwordID = passwordID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	@Override
	public String toString() {
		return "Password [passwordID=" + passwordID + ", password=" + password
				+ ", updateDate=" + updateDate + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result
				+ ((passwordID == null) ? 0 : passwordID.hashCode());
		result = prime * result
				+ ((updateDate == null) ? 0 : updateDate.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Password other = (Password) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (passwordID == null) {
			if (other.passwordID != null)
				return false;
		} else if (!passwordID.equals(other.passwordID))
			return false;
		if (updateDate == null) {
			if (other.updateDate != null)
				return false;
		} else if (!updateDate.equals(other.updateDate))
			return false;
		return true;
	}
	
	
}
