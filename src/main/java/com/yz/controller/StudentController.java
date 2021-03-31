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
import com.yz.response.UserLogin;
import com.yz.service.StudentService;
import com.yz.util.UUIDGenerator;

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
	public String login(@RequestBody UserLogin userlogin,HttpServletRequest request){
		
		String name=userlogin.getName();
		String password=userlogin.getPassword();
		String code=userlogin.getCode();
		String input=userlogin.getInput();
		List<Map<String,Object>> list = studentService.queryStudentList();
		for(int i=0;i<list.size();i++){
			if(name.equals(list.get(i).get("NAME"))&&password.equals(list.get(i).get("PASSWORD"))){
				if(code.equals(input)){
					HttpSession session=request.getSession();
					session.setAttribute("name", name);
					return "1";
				}else{
					return "2";
				}
	
			}
		}
		return "0";
		
	}
	@RequestMapping("/register")
	public String register(){
		
		return "register";
		
	}
	
	@RequestMapping("/queryuser")
	@ResponseBody
	public String queryuser(String phones){
		System.out.println(phones);
		Student student=studentService.queryuser(phones);
		System.out.println(student);
		if(student!=null&&!student.equals("")){
			return "0";
		}
		return "1";
		
	}
	
	@RequestMapping("adduser")
	@ResponseBody
	public String adduser(String name,String password){
		System.out.println(name+password);
		String id=new UUIDGenerator().generate().toString();
		studentService.adduser(id,name, password);
		System.out.println("adduser");
		return "redirect:index.html";
		
	}

}
