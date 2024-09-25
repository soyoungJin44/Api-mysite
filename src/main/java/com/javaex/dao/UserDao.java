package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PersonVo;

@Repository
public class UserDao {
	
	@Autowired
	private SqlSession sqlSession;
	

		public int insertPerson() {
			System.out.println("Dao insertperson");
			int count = 0;
			
			
			return count;
			
		}
		
		// 회원가입 (insert)
		public int insertPerson(PersonVo personVo) {
			
			int count = sqlSession.insert("user.insert", personVo);
			
			System.out.println(count);
			return count;
		}
		
		//로그인이용()
		
		public PersonVo selectUser(PersonVo personVo) {
			
			System.out.println("dao selectOne이용");
			System.out.println("dao"+personVo);
			
			PersonVo authUser = sqlSession.selectOne("user.selectOne", personVo);
			
			System.out.println(authUser);
			
			return authUser;
			
			
			
		}
		//수정 (한사람 정보 가져오기)
		public PersonVo getPersonOne(int no) {
			System.out.println("dao 한사람 가져오기");
			
			System.out.println("dao" + no);
			PersonVo personVo = sqlSession.selectOne("user.getPersonOne", no);
		
			System.out.println(personVo);
			return personVo;
//		
			
		}
		
		
		//수정 (update)
		public PersonVo update(PersonVo personVo) {
			System.out.println("Dao 업데이트용");
			
			int count = sqlSession.update("user.updatePerson", personVo);
			
			if(count == 1) {
				return personVo;
			}else {
				return null;
			}
			
			
		}
		
		//중복체크
		
		public int check(String id) {
			System.out.println("다오 중복체크 준비");

			int count = sqlSession.selectOne("user.check", id);
			
			return count;
			
			
		}
	
	
	
	

}