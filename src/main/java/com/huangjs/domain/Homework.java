package com.huangjs.domain;

import java.sql.Timestamp;

public class Homework {
    private Integer id;
    private String title;
    private String description;
    private Integer courseId;
    private Timestamp createTime;
    private Timestamp deadline;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getDeadline() {
        return deadline;
    }

    public void setDeadline(Timestamp deadline) {
        this.deadline = deadline;
    }


    public Homework() {
    }

    public Homework(Integer id, String title, String description, Integer courseId, Timestamp createTime, Timestamp deadline) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.courseId = courseId;
        this.createTime = createTime;
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return "Homework{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", courseId=" + courseId +
                ", createTime=" + createTime +
                ", deadline=" + deadline +
                '}';
    }
}
