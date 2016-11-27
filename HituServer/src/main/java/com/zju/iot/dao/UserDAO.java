package com.zju.iot.dao;

import com.zju.iot.entity.Password;
import com.zju.iot.entity.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.Date;
import java.util.List;


@Component
public class UserDAO {
	@Inject
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void addUser( User user){
		Session session = sessionFactory.getCurrentSession();
		session.save(user);
		session.flush();
	}
	
	/**
	 * 判断此用户名的User是否存在
	 * @param name
	 * @return
	 */
	public boolean isUserExist( String name ){
        User user = getUserByName(name);
        return user == null ? false : true;
	}
	
	/**
	 * 根据所给的用户名获取User
	 * @param name
	 * @return
	 */
	public User getUserByName( String name ){
		String hsql="from User user where user.name = ?";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hsql);
        query.setString(0, name);
        return (User) query.uniqueResult();
	}
	
	/**
	 * 获取所有的用户
	 * @return
	 */
	public List<User> getAllUser(){
		/**
		 * from User 或者 from user 都不行
		 */
        String hsql="from User user";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hsql);
        return query.list();
    }
	
	private void testAddUser(){
		Session session = sessionFactory.getCurrentSession();
		User user1 = new User();
		user1.setName("wangkun");
		user1.setSex("man");
		user1.setBirthday(new Date());
		user1.setPhone("15763948255");
		user1.setRegisterDate(new Date());
		Password password = new Password();
		password.setPassword("amei0309");
		password.setUpdateDate(new Date());
		user1.setPassword(password);
		session.save(user1);
	}
	
}
