package com.huangjs.domain;

public class Course {
    private Integer id;

    private String name;

    // the id of the teacher who teaches the course
    private String teacherId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public Course() {
    }

    public Course(Integer id, String name, String teacherId) {
        this.id = id;
        this.name = name;
        this.teacherId = teacherId;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", teacherId='" + teacherId + '\'' +
                '}';
    }
}
