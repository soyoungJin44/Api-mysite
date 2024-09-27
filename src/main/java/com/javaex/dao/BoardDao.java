package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BoardVo;

@Repository
public class BoardDao {
	
	@Autowired SqlSession sqlSession;
	
	//리스트 가져오기
	
	public List<BoardVo> personList() {
		System.out.println("dao 리스트 가져올준비");
		
		 List<BoardVo> personList = sqlSession.selectList("board.selectAll");
		
//		 System.out.println(personList);
		return personList;
		
	}
	
	//읽기
	
	public BoardVo read(int no) {
		System.out.println("Dao read준ㅇ비완");
		
		BoardVo boardVo = sqlSession.selectOne("board.selectOne",no);
		
		return boardVo;
		
	}
	
	//delete
	public int delete(BoardVo boardVo) {
		System.out.println("dao delete 준비");
		System.out.println("dao>>>>>" + boardVo);
		
		int count = sqlSession.delete("board.delete", boardVo);
		
		return count;
	}
	
	//수정 폼
	
	public BoardVo modify(int no) {
		System.out.println("dao 준완");
		
		//조회수 올리기
		
		
		
		BoardVo boardVo = sqlSession.selectOne("board.selectOne", no);
		
		return boardVo;
	}
	
	
	
	
	// 수정
	
	public int modifyWrite(BoardVo boardVo) {
		
		System.out.println("dao modifyform 준비 완");
		
		System.out.println(boardVo);
		int count = sqlSession.update("board.updateOne", boardVo);
		
		return count;
		
	}
	
	//write
	
	public int write(BoardVo boardVo) {
		
		System.out.println(boardVo);
		
		int count = sqlSession.insert("board.insert", boardVo);
		
		return count;
	}

}