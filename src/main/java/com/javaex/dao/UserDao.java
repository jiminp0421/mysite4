package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVo;

@Repository
public class UserDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	//UserController의 join임 insert로 써준 이유는 컨트롤러는 회원가입을 하게해줘서 join이고
	//DB는 파라미터 저장할거니까 isnert로 써준거야
	public int insert(UserVo userVo) {
		System.out.println("userDao.insert");
		
		return sqlSession.insert("user.insert", userVo);
	}
	
	public UserVo selectUser(UserVo userVo) {
		
		System.out.println("userDao:selectUser");

		
		return sqlSession.selectOne("user.selectUser", userVo);
		
	}


}
