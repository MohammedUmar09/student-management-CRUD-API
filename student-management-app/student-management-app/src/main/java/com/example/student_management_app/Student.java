package com.example.student_management_app;

public class Student {
    private int admno;

    private String name;

    private int age;

    private String email;

    private String course;

    public Student() {
    }

    public Student(int admno, String name, int age, String email, String course) {
        this.admno = admno;
        this.name = name;
        this.age = age;
        this.email = email;
        this.course = course;
    }

    public int getAdmno() {
        return admno;
    }

    public void setAdmno(int admno) {
        this.admno = admno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
