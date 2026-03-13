package model;

import java.sql.Date;

public class Student {

    private String student_id;
    private String name;
    private Date birth;
    private String major;
    private double gpa;
    private String class_name;

    public Student() {}

    public Student(String student_id, String name, Date birth, String major, double gpa, String class_name) {
        this.student_id = student_id;
        this.name = name;
        this.birth = birth;
        this.major = major;
        this.gpa = gpa;
        this.class_name = class_name;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getName() {
        return name;
    }

    public Date getBirth() {
        return birth;
    }

    public String getMajor() {
        return major;
    }

    public double getGpa() {
        return gpa;
    }

    public String getClass_name() {
        return class_name;
    }
}


