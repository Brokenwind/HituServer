package com.zju.iot.entity;

import lombok.Data;

import java.util.Date;
/**
 * User can login with his name,phone or email
 * @author Amei
 */

@Data
public class Password {
	private String userID;
	private String nickname;
	private String phone;
	private String email;
	private String password;
	private Date updateDate;
}
