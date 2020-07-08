package com.javaex.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaex.service.UserService;
import com.javaex.vo.UserVo;


@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/joinForm")
	public String joinForm() {
		System.out.println("/user/joinForm");
		
		return "user/joinForm";
		
	}
	
	@RequestMapping("/join")
	public String join(@ModelAttribute UserVo userVo) {
		System.out.println("userController/join");
		System.out.println(userVo.toString());
		
		userService.join(userVo);
		
		return "redirect:/main";
	}
	
	@RequestMapping("/loginForm")
	public String loginForm() {
		
		System.out.println("/user/loginForm");
		return"user/loginForm";
	}
	
	@RequestMapping("/login")
	public String login(@ModelAttribute UserVo userVo, HttpSession session) {
		
		System.out.println("userController/login");
		System.out.println(userVo.toString());
		
		UserVo authUser = userService.login(userVo); //저기에 값이 있으면 로그인성공 저기에 값이 없으면 로그인실패
		
		if(authUser != null) { //로그인 성공일때
			System.out.println("로그인 성공");
			session.setAttribute("authUser", authUser); //이건 로그인에 성공했을때!
			return "redirect:/main";
		}else {//로그인 실패일때
			System.out.println("로그인 실패");
			return "redirect:/user/loginForm?result=fail";
		}

	}
	
	
		

}
