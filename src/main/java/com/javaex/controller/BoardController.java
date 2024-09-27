package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.BoardService;
import com.javaex.util.JsonResult;
import com.javaex.vo.BoardVo;

@RestController
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	//List
	@GetMapping(value="/api/board/persons")
	public JsonResult getAllList() {
		System.out.println("board AllList j w");
		
		List<BoardVo> personList = boardService.exepersonList();
		System.out.println(personList);
		return JsonResult.success(personList);
	}

}
