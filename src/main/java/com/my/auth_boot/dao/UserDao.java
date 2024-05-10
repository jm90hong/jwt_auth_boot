package com.my.auth_boot.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.my.auth_boot.entity.User;

@Repository
public class UserDao {

	
	
	@Autowired
	SqlSession s;
	
	public User findByIdAndPw(User user) {
		return s.selectOne("UserMapper.findByIdAndPw",user);
	}
	
	
	public int updatePw(User user) {
		return s.update("UserMapper.updatePw",user);
	}
}
