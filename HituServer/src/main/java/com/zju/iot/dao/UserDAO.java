package com.zju.iot.dao;

import com.zju.iot.entity.User;
import org.springframework.stereotype.Component;

import javax.inject.Inject;


@Component
public class UserDAO {

    @Inject
    private BaseDAO baseDAO;

	public boolean addUser( User user){
        return baseDAO.save(user);
	}

	/**
	 * 根据所给的用户别名获取User
	 * @param nickname
	 * @return
	 */
	public User getUserByNickname(String nickname ){
		String hsql="from User user where user.nickname = ?";
		return (User) baseDAO.uniqueResult(hsql,nickname);

	}

    public long getUserCount(){
        String hsql="select count(*) from User user";
		return baseDAO.getCount(hsql);
    }
    public boolean isUserExist(String nickname){
		return getUserByNickname(nickname) != null ? true : false;
	}
}
