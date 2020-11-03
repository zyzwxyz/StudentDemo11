package com.example.demo1.Entity;

import java.io.Serializable;

public class Student implements Serializable {

    private static final long serialVersionUID = -2132656346486807030L;
    //id
    private Long id;
    //姓名
    private String name;
    //班级
    private String grade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }
}
