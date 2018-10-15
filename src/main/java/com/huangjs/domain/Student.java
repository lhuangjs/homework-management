package com.huangjs.domain;

public class Student {
    private String id;
    private String name;
    private String password;
    private String grade;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Student() {
    }

    public Student(String id, String name, String password, String grade) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }
}
