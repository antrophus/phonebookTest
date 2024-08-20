package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.PhonebookDao;
import com.javaex.vo.PersonVo;

@Controller
public class PhonebookController {
	
	//필드
	//Dao를 메모리에 올린다. 스프링부트에서 올려줌.
	@Autowired
	private PhonebookDao phonebookDao;
//	= private PhonebookDao phonebookDao = new PhonebookDao();
	
	//생성자
	
	//메소드 -gs
	
	//메소드 일반----------------------------------------------------
		
		/* 리스트 */
		@RequestMapping(value="/list", method= {RequestMethod.GET, RequestMethod.POST})
		public String list(Model model) {
			System.out.println("PhonebookController.list()");
			
//			//Dao를 메모리에 올린다.
//			PhonebookDao phonebookDao = new PhonebookDao();
			
			//PhonebookDao의 메소드(getPersonList)를 이용해서 데이터를 가져온다. 
			List<PersonVo> personList = phonebookDao.getPersonList();
			System.out.println(personList);
			
			model.addAttribute("personList", personList);
			
			return "list";
		}
	
		/* 등록폼 */
		@RequestMapping(value="/writeform", method={RequestMethod.GET, RequestMethod.POST})
		public String writeForm() {
			System.out.println("PhonebookController.writeForm");
			
			return "writeForm";
		}
		
		/* 등록 */
		/* Vo로 받을 때 */
		@RequestMapping(value="/write", method= {RequestMethod.GET, RequestMethod.POST})
		public String write(@ModelAttribute PersonVo personVo) {
			System.out.println("PhonebookController.write()");
			
//			//dao를 메모리에 올린다.
//		 	PhonebookDao phonebookDao = new PhonebookDao();
		 	
		 	//phonebookDao의 메소드를 이용해서 저장한다.
		 	int count = phonebookDao.insertPerson(personVo);
			System.out.println(count);
		 	
			//리스트로 리다이렉트
			return "redirect:/list";
		}
		/* 등록 (2) */
		/* 1개씩 파라미터 받아올 때 */
		@RequestMapping(value="/write2", method= {RequestMethod.GET, RequestMethod.POST})
		public String write2(@RequestParam(value="name") String name, 
							@RequestParam(value="hp") String hp, 
							@RequestParam(value="company") String company) {
			System.out.println("PhonebookController.write2()");
			
			System.out.println(name);
			System.out.println(hp);
			System.out.println(company);
			
			PersonVo personVo = new PersonVo(name, hp, company);
			return "";
		}
	
		 /* 수정폼 */
	    @RequestMapping(value="/editform", method={RequestMethod.GET, RequestMethod.POST})
	    public String editForm(@RequestParam(value="no") int no, Model model) {
	        System.out.println("PhonebookController.editForm()");
	        
	        // phonebookDao의 메소드를 이용해 수정할 데이터 가져오기
	        PersonVo personVo = phonebookDao.getPersonOne(no);
	        model.addAttribute("personVo", personVo);
	        
	        return "editForm";
	    }
		
		/* 수정 */
	    @RequestMapping(value="/edit", method={RequestMethod.GET, RequestMethod.POST})
	    public String edit(@ModelAttribute PersonVo personVo) {
	        System.out.println("PhonebookController.edit()");
	        
	        // phonebookDao의 메소드를 이용해 데이터 수정
	        int count = phonebookDao.updatePerson(personVo);
	        System.out.println(count);
	        
	        return "redirect:/list";
	    }
		
		
		/* 삭제 */
		@RequestMapping(value="delete", method = {RequestMethod.GET, RequestMethod.POST})
		public String delete(@RequestParam(value="no") int no) {
			System.out.println("PhonebookController.delete");
			
//			//Dao를 메모리에 올린다
//			PhonebookDao phonebookDao = new PhonebookDao();
			
			// phonebookDao의 메소드를 이용해서 데이터를 삭제한다.
			int count = phonebookDao.deletePerson(no);
			
			System.out.println(count);
			return "redirect:/list";
		}

		
	
	
	
}
