package com.zju.iot.controller.json;

import com.zju.iot.common.Message;
import com.zju.iot.common.Status;
import com.zju.iot.entity.User;
import com.zju.iot.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;


@Controller
@RequestMapping("/user")
public class UserController {
	private static Logger logger = Logger.getLogger(UserController.class);
	@Inject
	private UserService service;
	private Message message;

	@RequestMapping(value = "/count")
	@ResponseBody
	public Message  count() {
		message = new Message(Status.RETURN_OK);
		message.setResult(service.getUserCount());
		return message;
	}

	@RequestMapping(value = "/register")
	public String register(User user,String password) {
		int ret = service.registerUser(user,password).getStatusCode();
		boolean result =  ret == 0 ? true : false;
		return result == true ? "login" : "register";
	}

	@RequestMapping(value = "/qqRegister")
	@ResponseBody
	public Message register(User user) {
		return service.QQRegister(user);
	}


	@RequestMapping(value = "/qqLogin")
	@ResponseBody
	public Message qqLogin(User user) {
		return service.qqLogin(user);
	}

	/**
	 * 根据不同的登陆类型来登陆
	 * @param type : 登陆类型(不指定此参数时，默认为0)，包括: 0,默认的用用户别名登陆; 1,用电话号码登陆; 用email登陆
	 * @param account : 登陆帐号
	 * @param password : 账户密码
	 * @return
	 */
	@RequestMapping(value = "/login")
	public String signin(Integer type,String account, String password) {
		int ret = service.login(type,account,password).getStatusCode();
		logger.info("result is :"+ret);
		if ( ret == 0 )
			return "home";
		else
			return "login";
	}


	@RequestMapping(value = "/isExist")
	@ResponseBody
	public Message isExist(String name) {
		return service.isUserExist(name);
	}

	@RequestMapping(value = "/getUser")
	@ResponseBody
	public Message getSpecifiedUser(String name){
		return service.getUser(name);
	}
}
