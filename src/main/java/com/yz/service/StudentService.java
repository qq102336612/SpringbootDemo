package com.yz.service;

import java.util.List;
import java.util.Map;

import com.yz.entity.Student;

public interface StudentService {
	List<Map<String,Object>> queryStudentList();
	Student login(Student stu);

}
