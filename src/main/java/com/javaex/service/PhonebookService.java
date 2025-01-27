package com.javaex.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.PhonebookDao;
import com.javaex.vo.PersonVo;

@Service
public class PhonebookService {

	@Autowired
	private PhonebookDao phonebookDao;

	/* 등록 */
	public int exeWritePerson(PersonVo personVo) {
		System.out.println("PhonebookService.exeWritePerson()");

		int count = phonebookDao.insertPerson(personVo);

		return count;
	}

	/* 리스트 */
	public List<PersonVo> exeGetPerson() {
		System.out.println("PhonebookService.exeGetPerson()");

		List<PersonVo> personList = phonebookDao.getPersonList();

		return personList;
	}

	/* 삭제 */
	public int exePersonDelete(int no) {
		System.out.println("PhonebookService.exePersonDelete()");

		int count = phonebookDao.deletePerson(no);

		return count;
	}

	/* 수정폼 */
	public PersonVo exeEditForm(int no) {
		System.out.println("PhonebookService.exeEditForm()");
		// phonebookDao의 메소드를 이용해 수정할 데이터 가져오기
		PersonVo personVo = phonebookDao.getPersonOne(no);

		return personVo;
	}

	/* 수정 */
	public int exeEditPerson(PersonVo personVo) {
		System.out.println("PhonebookService.exeEditPerson()");
		int count = phonebookDao.updatePerson(personVo);

		return count;
	}
}
