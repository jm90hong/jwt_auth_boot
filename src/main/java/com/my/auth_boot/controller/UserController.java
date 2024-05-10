package com.my.auth_boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.auth_boot.config.JwtTokenUtil;
import com.my.auth_boot.entity.User;
import com.my.auth_boot.service.UserService;

@Controller
@RequestMapping(value="api/v1/user")
public class UserController {

	@Value("${jwt.token.secret}") // yml에 저장된 값을 가져온다.
    private String secretKey;
	
	@Autowired
	UserService userService;
	
	
	@GetMapping("/login")
	@ResponseBody
	public String login(
			@RequestParam(value="id") String id,
			@RequestParam(value="pw") String pw
			) {
		
		
		User user = new User();
		user.setId(id);
		user.setPw(pw);
		
		
		User result = userService.findByIdAndPw(user);
		String token="fail";
		if(result!=null) {
			token = JwtTokenUtil.generateToken(result.getId(), secretKey, 3*3600*1000);
		}
		
		return token;
	} 
	
	
	@GetMapping("/updatePw")
	@ResponseBody
	public String updatePw(
				@RequestParam(value="user_idx") int user_idx,
				@RequestParam(value="pw") String pw
			) {
		
		
		User user = new User();
		user.setUser_idx(user_idx);
		user.setPw(pw);
		
		
		
		userService.updatePw(user);
		
		
		return "ok";
	} 
	
	
}
