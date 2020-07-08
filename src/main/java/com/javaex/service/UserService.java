package com.javaex.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.UserDao;
import com.javaex.vo.UserVo;

@Service
public class UserService { //지금은 비즈니스로직으로만 이해하면돼.
	
	@Autowired 
	private UserDao userDao;
	
	//회원가입
	public int join(UserVo userVo) {
		System.out.println("userService.join");
		
		userDao.insert(userVo); //db관련된일
		
		return 1;
		
	}
	
	public UserVo login(UserVo userVo) {
		System.out.println("userService.login");
		UserVo authUser = userDao.selectUser(userVo);
		
		return authUser;
	}
}
