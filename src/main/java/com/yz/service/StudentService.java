package com.yz.service;

import java.util.List;
import java.util.Map;

import com.yz.entity.Student;

public interface StudentService {
	List<Map<String,Object>> queryStudentList();
	
	Student queryuser(String phone);
	
	void adduser(String id,String name,String password);

}
