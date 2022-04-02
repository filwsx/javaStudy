package com.filwsx.bean;

import org.springframework.beans.factory.config.ListFactoryBean;

import java.util.List;

/**
 * @author filwsx
 * @create 2022-04-02 11:53
 */
public class Course {
    private String courseName;
    private List<String> studentNameList;
    private Teacher teacher;

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void setStudentNameList(List<String> studentNameList) {
        this.studentNameList = studentNameList;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseName='" + courseName + '\'' +
                ", studentNameList=" + studentNameList +
                ", teacher=" + teacher +
                '}';
    }
}
