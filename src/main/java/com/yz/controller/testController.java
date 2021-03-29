package com.yz.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.yz.entity.Student;
import com.yz.response.Response;
import com.yz.service.StudentService;
@Controller

public class testController {
	public static final Logger LOGGER = LoggerFactory.getLogger(testController.class);
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
	@RequestMapping(value = "/studentList",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> studentList(HttpServletRequest request) {
		JSONObject jsonObject = new JSONObject();
		List<Map<String,Object>> list=studentService.queryStudentList();
		/*for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}*/
		jsonObject.put("code", 0);			
    	jsonObject.put("msg", "");			
    	jsonObject.put("count", 1000);			
    	jsonObject.put("data", list);
		System.out.println(jsonObject);
		return jsonObject;
	}
	@RequestMapping("yz")
	public String yz() {
		return "test";
	}
	
	/*@RequestMapping("login")
	public String login(){
		return "test";
	}*/


}
