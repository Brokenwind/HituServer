package com.zju.iot.service;

import com.zju.iot.common.Message;
import com.zju.iot.common.Status;
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
	private Message message = new Message();

	public Message getUser(String nickname){
		message.clear();
		if (nickname != null && !nickname.equals("")) {
			User user = userDAO.getUserByNickname(nickname);
			if (user == null)
				message = new Message(Status.NO_RESULT);
			else {
				message = new Message(Status.RETURN_OK);
				message.setResult(user);
			}
		}
		else {
			message = new Message(Status.ILLEGAL_PARAMS);
		}
		return message;
	}
	
	public Message isUserExist( String nickname){
		message.clear();
		if (nickname == null || nickname.equals("")){
			message = new Message(Status.ILLEGAL_PARAMS);
		}
		else{
			User user = userDAO.getUserByNickname(nickname);
			if ( user == null )
				message = new Message(Status.NO_RESULT);
			else{
				message = new Message(Status.RETURN_OK);
				message.setResult(user);
			}
		}
		return message;
	}

	/**
	 * 获取所有注册的人数
	 * @return
	 */
	public Message getUserCount(){
		message.clear();
		message = new Message(Status.RETURN_OK);
		message.setResult(userDAO.getUserCount());
		return message;
	}

	public Message registerUser(User user,String password) {
		message.clear();
		if (user.getNickname() == null || password == null) {
			message.setMessage(Status.ILLEGAL_PARAMS);
			message.setResult(false);
		}
		if (user.getNickname().equals("") || password.equals("")) {
			message.setMessage(Status.ILLEGAL_PARAMS);
			message.setResult(false);
		}
		if (userDAO.isUserExistByName(user.getNickname())) {
			message.setMessage(Status.HAVE_EXISTED);
			message.setResult(false);
		}
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
			if (userDAO.addUser(user) && passwordDAO.addPassword(pd)) {
				message.setMessage(Status.RETURN_OK);
				message.setResult(true);
			}
			else {
				message.setMessage(Status.INNER_ERROR);
				message.setResult(false);
			}
		}
		return  message;
	}

	/**
	 * register with qq account
	 * @param user
	 * @return
	 */
	public Message QQRegister(User user) {
		message.clear();
		if ( user == null || user.getUserID() == null || user.getNickname() == null || user.getUserID().equals("") ||user.getNickname().equals("")) {
			message.setMessage(Status.ILLEGAL_PARAMS);
			message.setResult(false);
		}
		else {
			if (userDAO.isUserExistByID(user.getUserID())) {
				message.setMessage(Status.HAVE_EXISTED);
				message.setResult(false);
			} else {
				if (userDAO.addUser(user)) {
					message.setMessage(Status.RETURN_OK);
					message.setResult(true);
				} else {
					message.setMessage(Status.INNER_ERROR);
					message.setResult(false);
				}
			}
		}
		return  message;
	}

	/**
	 * register with qq account
	 * @param user
	 * @return
	 */
	public Message qqLogin(User user) {
		message.clear();

		if ( user == null || user.getNickname() == null ||user.getNickname().equals("")) {
			message.setMessage(Status.ILLEGAL_PARAMS);
			message.setResult(false);
		}
		else {
			User ret = userDAO.getUserByNickname(user.getNickname());
			if (ret == null) {
				user.setUserID(UUID.randomUUID().toString());
				user.setRegisterDate(new Date());
				if (userDAO.addUser(user)) {
					message.setResult(user.getUserID());
					message.setMessage(Status.RETURN_OK);
				} else {
					message.setMessage(Status.INNER_ERROR);
					message.setResult(false);
				}
			}
			else {
				message.setResult(ret.getUserID());
				message.setMessage(Status.RETURN_OK);
			}
		}
		return  message;
	}

	public Message login(Integer type,String account,String password){
		message.clear();
		if ( type == null || account == null || password == null || account.equals("") || password.equals("")){
			message.setMessage(Status.ILLEGAL_PARAMS);
			message.setResult(false);
		}
		else {
			Password pd = passwordDAO.getPassword(type, account);
			if (pd != null) {
				boolean ret = pd.getPassword().equals(password);
				if (ret) {
					message.setMessage(Status.RETURN_OK);
					message.setResult(pd.getUserID());
				} else {
					message.setMessage(Status.AUTH_FAILED);
					message.setResult(false);
				}
			} else {
				message.setMessage(Status.NO_RESULT);
				message.setResult(false);
			}
		}
		return message;
	}

	/**
	 * no password login
	 * @param type
	 * @param account
	 * @return
	 */
	public Message login(Integer type,String account){
		message.clear();
		if ( type == null || account == null || account.equals("")){
			message.setMessage(Status.ILLEGAL_PARAMS);
			message.setResult(false);
		}
		else {
			boolean ret = userDAO.isUserExistByID(account);
			if (ret) {
				message.setMessage(Status.RETURN_OK);
				message.setResult(true);
			} else {
				message.setMessage(Status.AUTH_FAILED);
				message.setResult(false);
			}
		}
		return message;
	}
}
