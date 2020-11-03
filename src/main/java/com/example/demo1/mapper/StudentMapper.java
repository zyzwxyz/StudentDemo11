package com.example.demo1.mapper;

import com.example.demo1.Entity.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentMapper {
    //通过id查询学生
    @Select("select * from student where id=#{id}")
    public Student findById(Long id);
    //查询所有学生
    @Select("select * from student")
    @Results({
            @Result(id=true,column = "id",property = "id"),
            @Result(column="name",property="name"),
            @Result(column="grade",property="grade")
    })
    public List<Student> findAllStudent();
    //增加学生
    @Insert("insert into student(id,name,grade) values(#{id},#{name},#{grade})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    public int insert(Student student);
    //删除学生
    @Delete("delete from student where id = #{id}")
    public int delete(Long id);
}
