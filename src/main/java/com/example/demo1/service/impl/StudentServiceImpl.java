package com.example.demo1.service.impl;

import com.example.demo1.Entity.Student;
import com.example.demo1.mapper.StudentMapper;
import com.example.demo1.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> listAllStudent() {
        List<Student> list = studentMapper.findAllStudent();
        return list;
    }

    @Override
    public Student getStudent(Long id) {
        Student student = studentMapper.findById(id);
        try {
            return student;
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public int creatStudent(Student student) {
        int insert = studentMapper.insert(student);
        return insert;
    }

    @Override
    public int deleteStudent(Long id) {
        int delete = studentMapper.delete(id);
        return delete;
    }
}
