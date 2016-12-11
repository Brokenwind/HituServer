package com.zju.iot.service;

import com.zju.iot.dao.PasswordDAO;
import com.zju.iot.dao.UserDAO;
import com.zju.iot.entity.Password;
import com.zju.iot.entity.User;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.Date;
import java.util.UUID;


@Component
public class UserService {
	@Inject
	private UserDAO userDAO;
	@Inject
	private PasswordDAO passwordDAO;
	public UserDAO getUserDAO() {
		return userDAO;
	}
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	public User getUser(String nickname){
		if (nickname != null && !nickname.equals(""))
			return userDAO.getUserByNickname(nickname);
		else
			return null;
	}
	
	public boolean isUserExist( String nickname){
		return userDAO.getUserByNickname(nickname) == null ? false : true;
	}

	/**
	 * 获取所有注册的人数
	 * @return
	 */
	public long getUserCount(){
		return userDAO.getUserCount();
	}

	public boolean registerUser(User user,String password) {
		if (user.getNickname() == null || password == null)
			return false;
		if (user.getNickname().equals("") || password.equals(""))
			return false;
		if (isUserExist(user.getNickname()))
			return false;
		else {
			String id = UUID.randomUUID().toString();
			user.setUserID(id);
			Password pd = new Password();
			pd.setUserID(id);
			pd.setNickname(user.getNickname());
			pd.setPassword(password);
			pd.setUpdateDate(new Date());
			if (user.getPhone() != null && !user.getPhone().equals(""))
				pd.setPhone(user.getPhone());
			if (user.getEmail() != null && !user.getEmail().equals(""))
				pd.setEmail(user.getEmail());
			if (userDAO.addUser(user) && passwordDAO.addPassword(pd))
				return true;
			else
				return false;
		}
	}

	public boolean login(int type,String account,String password){
		Password pd = passwordDAO.getPassword(type,account);
		if (pd != null){
			return pd.getPassword().equals(password);
		}
		else
			return false;
	}

}
