package com.zju.iot.controller;

import com.zju.iot.entity.User;
import com.zju.iot.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;


@Controller
@RequestMapping("/user")
public class UserController {
	private static Logger logger = Logger.getLogger(UserController.class);
	@Inject
	private UserService service;

	@RequestMapping(value = "/count", method = RequestMethod.GET)
	@ResponseBody
	public long  count() {
		return service.getUserCount();
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(User user,String password) {
		logger.info(user);
		logger.info(password);
		boolean result = service.registerUser(user,password);
		return result == true ? "login" : "register";
	}

	/**
	 * 根据不同的登陆类型来登陆
	 * @param type : 登陆类型(不指定此参数时，默认为0)，包括: 0,默认的用用户别名登陆; 1,用电话号码登陆; 用email登陆
	 * @param account : 登陆帐号
	 * @param password : 账户密码
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String signin(int type,String account, String password) {
		if ( service.login(type,account,password))
			return "home";
		else
			return "login";
	}

	@RequestMapping(value = "/isExist", method = RequestMethod.POST)
	@ResponseBody
	public String isExist(String name) {
		System.out.println(name);
		 return String.valueOf(service.isUserExist(name));
	}

	@RequestMapping(value = "/getUser", method = RequestMethod.GET)
	@ResponseBody
	public User getSpecifiedUser(String name){
		logger.info(name);
		return service.getUser(name);
	}
}
