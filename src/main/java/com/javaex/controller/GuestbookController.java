package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.GuestbookService;
import com.javaex.vo.GuestbookVo;

@RestController
public class GuestbookController {
	@Autowired
	private GuestbookService guestbookService;
	
	//list
	@GetMapping(value="/api/guest/persons")
	public void getList() {
		System.out.println("list j w");
		
		List<GuestbookVo> personList = guestbookService.exepersonList();
		System.out.println(personList);
		
	}
	

}
