package com.example.demo1.service;

import com.example.demo1.Entity.Student;

import java.util.List;

public interface StudentService {
    //查询所有学生
    List<Student> listAllStudent();
    //通过id查询学生
    Student getStudent(Long id);
    //创建一个学生
    int creatStudent(Student student);
    //删除一个学生
    int deleteStudent(Long id);
}