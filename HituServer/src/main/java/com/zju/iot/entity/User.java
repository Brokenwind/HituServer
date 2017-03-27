package com.zju.iot.entity;

import lombok.Data;

import java.util.Date;

/**
 * 用户
 * @author Amei
 */

@Data
public class User {
	private String userID;
	private String nickname;
	private String realname;
	private String sex;
	private Date birthday;
	private String phone;
	private String email;
	private String province;
	private String city;
	private String address;
	private String profileImageUrl;
	private String description;
	private Date registerDate;
	// 找回密码时用到的信息
	private String validataCode;
	private Long expierTime;
	public void setUser(User source){
		if ( source != null ){
			if ( source.getRealname() != null )
				this.setProfileImageUrl(source.getRealname());
			if ( source.getSex() != null )
				this.setSex(source.getSex());
			if ( source.getBirthday() != null )
				this.setBirthday(source.getBirthday());
			if ( source.getPhone() != null )
				this.setPhone(source.getPhone());
			if ( source.getEmail() != null )
				this.setEmail(source.getEmail());
			if ( source.getProvince() != null )
				this.setProvince(source.getProvince());
			if ( source.getCity() != null )
				this.setCity(source.getCity());
			if ( source.getAddress() != null )
				this.setAddress(source.getAddress());
			if ( source.getProfileImageUrl() != null )
				this.setProfileImageUrl(source.getProfileImageUrl());
			if ( source.getDescription() != null )
				this.setDescription(source.getDescription());
			if ( source.getRegisterDate() != null )
				this.setRegisterDate(source.getRegisterDate());
			if ( source.getValidataCode() != null )
				this.setValidataCode(source.getValidataCode());
			if ( source.getExpierTime() != null )
				this.setExpierTime(source.getExpierTime());
		}
	}
}
