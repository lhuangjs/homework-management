package com.huangjs.service;

import com.huangjs.domain.Course;
import com.huangjs.domain.Homework;
import com.huangjs.domain.Teacher;
import com.huangjs.domain.TeachingClass;

import java.util.List;

public interface TeacherService {

    /**
     * 创建课程
     *
     * @param course
     */
    void createCourse(Course course);


    /**
     * 创建班级
     *
     * @param teachingClass
     */
    void createTeachingClass(TeachingClass teachingClass);

    /**
     * 新建一个作业
     *
     * @param homework
     */
    void createHomework(Homework homework);

    /**
     * 根据id获取教师信息
     *
     * @param id 教师id
     * @return
     */
    Teacher getTeacherById(String id);

    /**
     * 根据教师id获取该教师所教授（创建）的课程
     *
     * @param teacherId 教师id
     * @return
     */
    List<Course> getCourseByTeacherId(String teacherId);

    /**
     * 根据作业所属课程的id获取作业记录
     *
     * @param courseId 作业所属课程的id
     * @return
     */
    List<Homework> getHomeworkByCourseId(int courseId);
}
