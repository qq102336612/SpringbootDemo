package com.yz.mapper;

import com.yz.entity.Student;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface StudentMapper{
	List<Map<String,Object>> queryStudentList();
	
	Student queryuser(String phones);
	
	void adduser(@Param(value = "id") String id,@Param(value = "name") String name,@Param(value = "password") String password);

}
