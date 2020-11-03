package com.example.demo1.Controller;

import com.example.demo1.Entity.Student;
import com.example.demo1.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/student")
public class StudentController {

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentService studentService;

    //查询所有学生
    @RequestMapping(value = "/students",method = RequestMethod.GET)
    public Object queryAllStudent(){
        Map<String, Object> map = new HashMap<>();
        List<Student> studentList = studentService.listAllStudent();
        try{
            map.put("status","ok");
            map.put("list",studentList);
        }catch (Exception e){
            map.put("status","failure");
            map.put("errMsg",e.getMessage());
            logger.error(e.getMessage(),e);
        }finally {
        }
        return map;
    }

    //通过id查询学生
    @RequestMapping(value = "/findstudent",method = RequestMethod.GET)
    public Object queryStudentById(@RequestParam(value = "id") Long id) {
        Map<String, Object> map = new HashMap<String, Object>();
        Student student = studentService.getStudent(id);
        try{
            if (student != null) {
                map.put("status","ok");
                map.put("student",student);
            }else {
                map.put("status","failure");
                map.put("reeMsg","用户不存在");
            }
        }catch(Exception e){
            map.put("status","failure");
            map.put("errMsg",e.getMessage());
            logger.error(e.getMessage(),e);
        }finally {
        }
        return map;
    }

    //添加一个学生
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public Object addStudent(@RequestParam(value = "id",required = true) Long id,
                           @RequestParam(value = "name",required = true)String name,
                           @RequestParam(value = "grade")String grade){
        Map<String, Object> map = new HashMap<>();
        Student student = new Student();
        student.setId(id);
        student.setName(name);
        student.setGrade(grade);
        int count = studentService.creatStudent(student);
        try{
            if (count > 0 ) {
                map.put("status","创建成功");
                map.put("student",student);
            }else{
                map.put("status","failure");
                map.put("errMsg","用户创建失败");
            }
        }catch(Exception e){
            map.put("status","failure");
            map.put("errMsg",e.getMessage());
            logger.error(e.getMessage(),e);
        }finally {
        }
        return map;
    }

    //删除一个学生
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    public Object deleteStudent(@PathVariable Long id){
        Map<String, Object> map = new HashMap<>();
        int count = studentService.deleteStudent(id);
        try{
            if (count > 0){
                map.put("status","删除成功");
            }else{
                map.put("status","failure");
                map.put("errMsg","用户删除失败");
            }
        }catch (Exception e){
            map.put("status","failure");
            map.put("errMsg",e.getMessage());
            logger.error(e.getMessage(),e);
        }finally {
        }
        return map;
    }
}
