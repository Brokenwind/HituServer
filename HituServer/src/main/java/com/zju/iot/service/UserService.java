package com.zju.iot.service;

import com.zju.iot.dao.UserDAO;
import com.zju.iot.entity.User;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.Date;
import java.util.List;

@Component
public class UserService {
	@Inject
	private UserDAO userDAO;
	
	public UserDAO getUserDAO() {
		return userDAO;
	}
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	public User getUser(String name){
		if (name != null && !name.equals(""))
			return userDAO.getUserByName(name);
		else
			return null;
	}
	
	public boolean isUserExist( String name){
		return userDAO.isUserExist(name);
	}
	/**
	 * 获取所有注册的人数
	 * @return
	 */
	public int getUserCount(){
		return userDAO.getAllUser().size();
	}
	
	public List<User> getAllUsers(){
		return userDAO.getAllUser();
	}

	public boolean registerUser(User user) {
		if (user.getName() == null || user.getPassword().getPassword() == null)
			return false;
		if (user.getName().equals("")
				|| user.getPassword().getPassword().equals(""))
			return false;
		if (userDAO.isUserExist(user.getName()))
			return false;
		else {
			user.getPassword().setUpdateDate(new Date());
			userDAO.addUser(user);
			return userDAO.isUserExist(user.getName());
		}

	}

	
}
