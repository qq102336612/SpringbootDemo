package com.yz.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yz.entity.Student;
import com.yz.service.StudentService;

@Controller
public class StudentController {
	public static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);
	@Autowired
	private StudentService studentService;
	
	public StudentService getStudentService() {
		return studentService;
	}
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	public static Logger getLogger() {
		return LOGGER;
	}
	@RequestMapping(value="/login",method = RequestMethod.POST)
	@ResponseBody
	public String login(@RequestBody Student student,HttpServletRequest request){
		
		String name=student.getName();
		String password=student.getPassword();
		List<Map<String,Object>> list = studentService.queryStudentList();
		for(int i=0;i<list.size();i++){
			if(name.equals(list.get(i).get("NAME"))&&password.equals(list.get(i).get("PASSWORD"))){
				HttpSession session=request.getSession();
				System.out.println(name+"11111111111111111111111111111111111");
				session.setAttribute("name", name);
				return "1";
			}
		}
		return "0";
		
	}

}
