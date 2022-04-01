package com.filwsx.bean;

/**
 * @author filwsx
 * @create 2022-04-01 18:25
 */
public class Emp {
    private String eName;
    private String gender;

    private Dept dept;

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public String getName() {
        return eName;
    }

    public void setName(String eName) {
        this.eName = eName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "eName='" + eName + '\'' +
                ", gender='" + gender + '\'' +
                ", dept=" + dept +
                '}';
    }
}
