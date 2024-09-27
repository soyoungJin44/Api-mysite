package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.GuestbookService;
import com.javaex.util.JsonResult;
import com.javaex.vo.GuestbookVo;

@RestController
public class GuestbookController {
	@Autowired
	private GuestbookService guestbookService;
	
	//list
	@GetMapping(value="/api/guest/persons")
	public JsonResult getList() {
		System.out.println("list j w");
		
		List<GuestbookVo> personList = guestbookService.exepersonList();
		System.out.println(personList);
		
		return JsonResult.success(personList);
	}
	
	//delete
	@DeleteMapping(value="/api/guest/persons/{no}")
	public JsonResult deleteOne(@PathVariable (value="no") int no, @RequestBody GuestbookVo guestbookVo) {
		System.out.println("reaccccccccccccccccccccccccccccccct del j w");
		
		guestbookVo.setNo(no);

		int count = guestbookService.exeDelete(guestbookVo);
		
		if(count != 0) {
			return JsonResult.success(count);
		}else {
			return JsonResult.fail("등록실패");
		}
	}
	
	@PostMapping(value="/api/guest/persons")
	public JsonResult insert(@RequestBody GuestbookVo guestbookVo) {
		System.out.println("insert j w");
		System.out.println(guestbookVo);
		
		int count = guestbookService.exeAdd(guestbookVo);
		
		if(count != 0) {
			return JsonResult.success(count);
		}else {
			return JsonResult.fail("등록실패");
		}
		
	}
	

}
