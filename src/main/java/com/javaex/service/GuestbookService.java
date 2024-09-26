package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.GuestbookDao;
import com.javaex.vo.GuestbookVo;

@Service
public class GuestbookService {
	
	@Autowired GuestbookDao guestbookDao;
	
	//리스트
	public List<GuestbookVo> exepersonList(){
		
		List<GuestbookVo> exepersonList = guestbookDao.personList();
		System.out.println("service" + exepersonList);
		
		return exepersonList;
	}
	
	//등록
	
	public GuestbookVo exeAdd(GuestbookVo guestbookVo) {
		System.out.println("service insert");
		
		//저장 insert해주기
		int count = guestbookDao.insertSelectKey(guestbookVo);
		
		//한명 정보 가져오기
		GuestbookVo personOneVo = guestbookDao.guestbookSelectOne(guestbookVo.getNo());
		
		return personOneVo;
	}
	
	//삭제
	
	public int exeDelete(GuestbookVo guestbookVo) {
		System.out.println("service 삭제용");
		
		int count = guestbookDao.delete(guestbookVo);
		
		return count;
		
		
	}
	
	

}