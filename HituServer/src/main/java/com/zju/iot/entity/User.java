package com.zju.iot.entity;

import lombok.Data;

import java.util.Date;

/**
 * 用户
 * @author Amei
 */

@Data
public class User {
	private String  id;
	private String name;
	private String sex;
	private Date birthday;
	private String phone;
	private String email;
	private String address;
	private String profileImageUrl;
	private String description;
	private Date registerDate;
	private Password password;
}
