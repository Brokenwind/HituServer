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
}
