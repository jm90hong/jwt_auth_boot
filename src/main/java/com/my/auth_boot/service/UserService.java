package com.my.auth_boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.auth_boot.dao.UserDao;
import com.my.auth_boot.entity.User;

@Service
public class UserService {

	
	
	@Autowired
	UserDao userDao;
	
	public User findByIdAndPw(User user) {
		return userDao.findByIdAndPw(user);
	}
	
	
	public int updatePw(User user) {
		return userDao.updatePw(user);
	}
}
