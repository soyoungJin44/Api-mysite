package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.UserDao;
import com.javaex.vo.PersonVo;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	// 회원가입(insert)
	public int exeInsertPerson(PersonVo personVo) {
		
		System.out.println("service insert용");
		
		int count = userDao.insertPerson(personVo);
		System.out.println(count);
		
		
		return count;
		
	}
	
	//로그인(selectOne)
	
	public PersonVo exeSelectOne(PersonVo personVo) {
		System.out.println("service selectOne이용");
		
		PersonVo authUser = userDao.selectUser(personVo);
		System.out.println("service"+personVo);
		
		
		return authUser;
		
	}
	
	//수정폼 (한사람 정보 가져오기)(자료형은 리턴)
	public PersonVo getPersonOne(int no) {
		
		System.out.println("service 사람정보 가져오기");
		
		int count = -1;
		
		PersonVo personVo = userDao.getPersonOne(no);
		System.out.println("sevice"+no);
		System.out.println(count);
		
		return personVo;
	}
	
	
	//수정기능
	
	public int exeupdatePerson(PersonVo personVo) {
		
		System.out.println("service updateperson이용");
		
		int count = userDao.update(personVo);
		
//		PersonVo npersonVo = userDao.getPersonOne(personVo.getNo());
		
		
		return count;
	}
	
	//중복체크
	
	public boolean execheck(String id) {
		System.out.println("중복체크 서비스 준비");
		
		int count = userDao.check(id);
		
		if(count >= 1) {
			return true;
		}else {
			return false;
		}
		
	}
	
	
}