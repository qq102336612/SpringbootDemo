package com.yz.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yz.entity.Student;
import com.yz.mapper.StudentMapper;
import com.yz.service.StudentService;
@Service(value = "StudentService")
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentMapper studentMapper;
	
	public StudentMapper getStudentMapper() {
		return studentMapper;
	}


	public void setStudentMapper(StudentMapper studentMapper) {
		this.studentMapper = studentMapper;
	}


	@Override
	public List<Map<String,Object>> queryStudentList() {
		
		return studentMapper.queryStudentList();
	}


	@Override
	public Student queryuser(String phones) {
		
		return studentMapper.queryuser(phones);
	}


	@Override
	public void adduser(String id,String name, String password) {
		studentMapper.adduser(id,name, password);
	}

}
