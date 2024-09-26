package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestbookVo;

@Repository
public class GuestbookDao {
	
	@Autowired SqlSession sqlSession;

	
	public List<GuestbookVo> personList(){
		
		List<GuestbookVo> personList = sqlSession.selectList("guestbook.selectAll");
		
		System.out.println("/./////////////////////////////////////");
		System.out.println("Dao" + personList);
		
		return personList;
		
	}
	
	//등록
	public int insertSelectKey(GuestbookVo guestbookVo) {
		System.out.println("dao insert");
		
		System.out.println(guestbookVo);
//		int count = sqlSession.insert("guestbook.insert", guestbookVo);
		
		int count = sqlSession.insert("guestbook.insertSelectKey", guestbookVo);
		System.out.println(guestbookVo);
		
		
		//가져온 키값으로 한명데이터 가져오기    !! 다오는 1개의 커리문만 가지고있어야한다.
		
//		GuestbookVo personOneVo = sqlSession.selectOne("guestbook.selectOne",guestbookVo.getNo());
//		
//		System.out.println(personOneVo);
		return count;
		
	}
	
	//ajax 새로만든 key값으로 1명 값 가져오기
	
	public GuestbookVo guestbookSelectOne(int no) {
		System.out.println("guestbookSelectOne");
		
		GuestbookVo personOneVo = sqlSession.selectOne("guestbook.selectOne",no);
	
		return personOneVo;
		
	}
	
	//삭제
	
	public int delete(GuestbookVo guestbookVo) {
		System.out.println("dao 삭제준ㄴ비");
		
		
		int count = sqlSession.delete("guestbook.delete",guestbookVo);
		
		return count;
		
		
	}
}