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
	public int  count() {
		return service.getUserCount();
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(User user) {
		logger.info(user);
		/**判断此姓名是否已经注册*/
		boolean result = service.isUserExist(user.getName());
		/**没有注册则添加*/
		if ( result == false ){
			result = service.registerUser(user);
			return result == true ? "login" : "register";
		}
		return  "register";
	}

	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public String signIn(String name, String password) {
		User user = service.getUser(name);
		System.out.println(user);
		if (null == user || !user.getPassword().getPassword().equals(password))
			return "login";
		else
			return "home";
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

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test() {
		return "index";
	}

}
