package com.huangjs.domain;

public class TeachingClass {
    private Integer id;
    private String name;
    private Integer courseId;

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

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public TeachingClass() {
    }

    public TeachingClass(Integer id, String name, Integer courseId) {
        this.id = id;
        this.name = name;
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        return "TeachingClass{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", courseId=" + courseId +
                '}';
    }
}
