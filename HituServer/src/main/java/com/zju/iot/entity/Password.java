package com.zju.iot.entity;

import lombok.Data;

import java.util.Date;
/**
 * 密码
 * @author Amei
 */

@Data
public class Password {
	private String  passwordID;
	private String password;
	private Date updateDate;
}
