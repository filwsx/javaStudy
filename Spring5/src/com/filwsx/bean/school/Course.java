package com.filwsx.bean.school;

import java.util.List;

/**
 * @author filwsx
 * @create 2022-04-02 12:25
 */
public class Course {
    private String courseName;
    private List<Student> studentList;
    private Teacher teacher;

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
