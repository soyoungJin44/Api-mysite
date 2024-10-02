package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.AttachService;
import com.javaex.util.JsonResult;
import com.javaex.vo.AttachVo2;

@RestController
public class AttachController {
	@Autowired
	private AttachService attachService;
	
	
//	@PostMapping(value="/api/attachs")
//	public JsonResult from(@RequestParam("profileImg") MultipartFile profileImg ) {
//		System.out.println("attach j w");
//		System.out.println(profileImg.getOriginalFilename());
//		
//		String saveNmae = attachService.exeupload(profileImg);
//		return JsonResult.success(saveNmae);
//		
//	}
	
//	@PostMapping(value="/api/attachs2")
//	public JsonResult from2(@RequestParam("profileImg") MultipartFile profileImg,
//							@RequestParam("content")String content) {
//		System.out.println("attach2 j w");
//		System.out.println(profileImg.getOriginalFilename());
//		System.out.println(content);
//		
//		return null;
//	}
	
	@PostMapping(value="/api/attachs2")
	public JsonResult from2(@ModelAttribute AttachVo2 attachVo2) {
		System.out.println("attach2 j w");
		System.out.println(attachVo2);
		
		String saveName = attachService.exeupload2(attachVo2);
		System.out.println(attachVo2);
		return JsonResult.success(saveName);
		
	}
	
	
	
	
	
}
