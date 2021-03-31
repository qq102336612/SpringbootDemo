package com.yz.mapper;

import com.yz.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public interface StudentMapper{
	List<Map<String,Object>> queryStudentList();
	Student login(Student stu);

}
