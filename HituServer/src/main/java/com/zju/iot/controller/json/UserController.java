package com.zju.iot.controller.json;

import com.zju.iot.common.Message;
import com.zju.iot.common.Status;
import com.zju.iot.entity.User;
import com.zju.iot.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.io.File;


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
		logger.info("register:"+user);
		int ret = service.registerUser(user,password).getStatusCode();
		boolean result =  ret == 0 ? true : false;
		return result == true ? "login" : "register";
	}

	@RequestMapping(value = "/qqRegister")
	@ResponseBody
	public Message register(User user) {
		return service.QQRegister(user);
	}


	@RequestMapping(value = "/qqLogin",method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public Message qqLogin(User user) {
		logger.info("user content: "+user);
		return service.qqLogin(user);
	}

	/**
	 * 根据不同的登陆类型来登陆
	 * @param type : 登陆类型(不指定此参数时，默认为0)，包括: 0,默认的用用户别名登陆; 1,用电话号码登陆; 用email登陆
	 * @param account : 登陆帐号
	 * @param password : 账户密码
	 * @return
	 */
	@RequestMapping(value = "/login" )
	public String signin(Integer type,String account, String password) {
		int ret = service.login(type,account,password).getStatusCode();
		logger.info("result is :"+ret);
		if ( ret == 0 )
			return "home";
		else
			return "login";
	}

	@RequestMapping(value = "/weblogin")
	@ResponseBody
	public Message login(Integer type,String account, String password) {
		return service.login(type,account,password);
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

	@RequestMapping(value = "/updateUser")
	@ResponseBody
	public Message updateUser(User user){
		return service.updateUser(user);
	}

	@RequestMapping(value = "/updateHead")
	@ResponseBody
	public Message upload(@RequestParam(value = "file", required = false) MultipartFile file, String userID, HttpServletRequest request) {
		message = new Message();
		String path = System.getProperty("webappRoot");
		path = path+"profileImages"+System.getProperty("file.separator");
		logger.info("image path:" + path);
		if ( file != null && userID != null ) {
			String fileName = file.getOriginalFilename();
			String suffix = fileName.substring(fileName.indexOf('.'),fileName.length());
			logger.info("suffix: "+suffix);
			Message msg = service.getUserByID(userID);
			if ( msg.isSuccess() ){
				User user = (User) msg.getResult();
				fileName = user.getUserID()+suffix;
				File targetFile = new File(path, fileName);
				if (!targetFile.exists()) {
					targetFile.mkdirs();
				}
				//save file
				try {
					file.transferTo(targetFile);
					user.setProfileImageUrl(fileName);
					logger.info("profile: "+targetFile.getAbsolutePath());
					message = service.updateUser(user);
				} catch (Exception e) {
					e.printStackTrace();
					message.setMessage(Status.INNER_ERROR);
				}
			}
			else {
				message.setMessage(Status.USER_NOT_EXISTED);
			}
		}
		else {
			message.setMessage(Status.ILLEGAL_PARAMS);
		}
		return message;
	}
}
