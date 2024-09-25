package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.UserService;
import com.javaex.util.JsonResult;
import com.javaex.util.JwtUtil;
import com.javaex.vo.PersonVo;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	//회원가입
	@PostMapping(value="/api/persons")
	public JsonResult join(@RequestBody PersonVo personVo) {
		int count = userService.exeInsertPerson(personVo);
		
		if(count == 1) {
			return JsonResult.success(count);
		}else {
			return JsonResult.fail("회원가입실패요");
		}
		
	}
	
	//로그인
	
	@PostMapping(value="/api/users/login")		//response값을 모르니까 불러오고
	public JsonResult login(@RequestBody PersonVo personVo,
							HttpServletResponse response) {
		
		PersonVo authUser = userService.exeSelectOne(personVo);
		
		if(authUser != null) {
			//토큰을 만들고 응답문서의 헤더에 토큰을 붙여서 보낸다.
			JwtUtil.createTokenAndSetHeader(response, ""+authUser.getNo());
			return JsonResult.success(authUser);
		}else {
			return JsonResult.fail("아이디,패스워드가 틀렸습니다.");
		}
		
		
		//token값 만들때, 가져온 no값 넣어서 만들어줌 (안에 값이 문자열만 들어가게되어있어서 문자열로 바꿔줌)
		//String token = JwtUtil.createToken(""+authUser.getNo());
		//보낼 때 response를 적어서 보내줘야함 
	}
	
	@PostMapping(value="/api/personId")
	public JsonResult idCheck(@RequestBody PersonVo personVo) {
		System.out.println(personVo);
		String id = personVo.getId();
		
		boolean result = userService.execheck(id);
		System.out.println(result);
		
		if(result == false) {
			return JsonResult.success(result);
		}else{
			return JsonResult.fail("중복됨");
		}
		
	}
	

}
