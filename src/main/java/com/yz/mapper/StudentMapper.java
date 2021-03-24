package com.yz.mapper;

import com.yz.entity.Student;
import java.util.List;
import java.util.Map;

public interface StudentMapper{
	List<Map<String,Object>> queryStudentList();

}
