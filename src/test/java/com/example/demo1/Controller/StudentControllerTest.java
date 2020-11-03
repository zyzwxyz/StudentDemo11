package com.example.demo1.Controller;

import com.example.demo1.Entity.Student;
import com.example.demo1.mapper.StudentMapper;
import com.example.demo1.service.StudentService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentControllerTest {

    @Autowired
    private StudentService studentService;

    @Before
    public void setUp() throws Exception {
        System.out.println("开始测试----------");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("测试结束----------");
    }

    @Test
    public void queryAllStudent() {
        List<Student> students = studentService.listAllStudent();
        System.out.println(students);
    }

    @Test
    public void queryStudentById() {
        Student student = studentService.getStudent((long) 5);
        System.out.println(student.toString());
    }

    @Test
    public void addStudent() {
        Student student = new Student();
        student.setName("zhengyz");
        student.setGrade("234");
        studentService.creatStudent(student);
    }

    @Test
    public void deleteStudent() {
        studentService.deleteStudent((long) 4);
    }
}