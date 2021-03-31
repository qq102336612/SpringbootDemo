package com.yz.controller.sys;

import com.yz.entity.Student;
import com.yz.service.StudentService;
import com.yz.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/sys")
public class LoginController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/login")
    public String login(@RequestBody Student student, HttpServletRequest request){
        Student stu = studentService.login(student);
        String pwdMd5 = MD5Util.string2MD5(String.valueOf(stu.getId())+student.getPassword());
        student.setPassword(pwdMd5);
        if(stu!=null){
            if(stu.getPassword().equals(student.getPassword())){
                HttpSession session=request.getSession();
                session.setAttribute("name", stu.getName());

                return "1";
            }else {
                return "密码错误";
            }

        }else {
            return "用户不存在！";
        }

    }



}
