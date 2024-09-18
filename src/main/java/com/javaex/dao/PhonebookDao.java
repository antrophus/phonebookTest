package com.javaex.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PersonVo;

@Repository
public class PhonebookDao {

	// 필드
	@Autowired
	private SqlSession sqlSession;

	// 생성자
	// 기본생성자 사용(그래서 생략)

	// 메소드 gs
	// 필드값을 외부에서 사용하면 안됨(그래서 생략)

	// 메소드 일반

	/* 삭제 */
	public int deletePerson(int no) {
		System.out.println("PhonebookDao.deletePerson()");
		//mybatis한테 넘겨서 해줘! 하면 해줌 막 지가 디비 연결도 하고 쿼리문 다 쓰고 트라이 캐치도 쓰고 다해줌
		int count = sqlSession.delete("phonebooktest.delete", no);

		return count;
	}

	// 사랑 1명 정보 수정하기 
	public int updatePerson(PersonVo personVo) {
		System.out.println("PhonebookDao.updatePerson()");
		int count = sqlSession.update("phonebooktest.update", personVo);

		return count;
	}

	// 사람 1명 정보 가져오기
	public PersonVo getPersonOne(int no) {
		System.out.println("PhonebookDao.getPersonOne()");
		
		PersonVo personVo = sqlSession.selectOne("phonebooktest.selectOne", no);
		
		return personVo;
	}
	
	// 사람정보 저장
	public int insertPerson(PersonVo personVo) {
		System.out.println("PhonebookDao.insertPerson()");
		
		int count = sqlSession.insert("phonebooktest.insert", personVo);
		
		return count;
	}

	// 리스트 가져오기
	public List<PersonVo> getPersonList() {
		System.out.println("PhonebookDao.getPersonList()");
		
		List<PersonVo> personList = sqlSession.selectList("phonebooktest.selectList");
		
		return personList;
	}
}
