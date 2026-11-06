package com.webtech;

import java.math.BigDecimal;

public class Student {

    private String rollno;
    private String name;
    private String gender;
    private String department;
    private BigDecimal cgpa;

    public Student(String rollno, String name,
            String gender, String department,
            BigDecimal cgpa) {

        this.rollno = rollno;
        this.name = name;
        this.gender = gender;
        this.department = department;
        this.cgpa = cgpa;
    }

    public String getRollno() {
        return rollno;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getDepartment() {
        return department;
    }

    public BigDecimal getCgpa() {
        return cgpa;
    }
}
