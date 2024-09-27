package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.AttachVo2;

@Repository
public class AttachDao {
	@Autowired
	SqlSession sqlSession;
	
	//파일 업로드
	
	public int upload(AttachVo2 attachVo2) {
		System.out.println("dao upload 준 완");

		int count = sqlSession.insert("attach.insert", attachVo2);
		
		System.out.println("yooooooooooooooooa!!" + count);
		return count;
	}
	
}