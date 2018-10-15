package com.huangjs.service;

import com.huangjs.domain.Course;
import com.huangjs.domain.Homework;
import com.huangjs.domain.Teacher;
import com.huangjs.domain.TeachingClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TeacherServiceImplTest {

    @Autowired
    private TeacherService teacherService;

    @Test
    public void createCourse() {
        Course course = new Course();
        course.setName("生物信息学");
        course.setTeacherId("t-001");
        teacherService.createCourse(course);
    }

    @Test
    public void createTeachingClass() {
        TeachingClass teachingClass = new TeachingClass();
        teachingClass.setName("bio-c1");
        teachingClass.setCourseId(1);
        teacherService.createTeachingClass(teachingClass);
    }

    @Test
    public void createHomework() {
        Homework homework = new Homework();
        homework.setTitle("生物数据库");
        homework.setDescription("搜集常用生物数据库");
        homework.setCourseId(1);
        homework.setDeadline(Timestamp.valueOf("2018-10-14 21:43:12.0"));
        teacherService.createHomework(homework);
    }

    @Test
    public void createHomework2() {
        Homework homework = new Homework();
        homework.setTitle("生物数据库");
        homework.setCourseId(1);
        homework.setDeadline(Timestamp.valueOf("2018-10-14 21:43:12.0"));
        teacherService.createHomework(homework);
    }

    @Test
    public void getTeacherById() {
        Teacher teacher = teacherService.getTeacherById("t-001");
        System.out.println(teacher);
    }

    @Test
    public void getCourseByTeacherId() {
        List<Course> courseList = teacherService.getCourseByTeacherId("t-001");
        for (Course course : courseList) {
            System.out.println(course);
        }
    }

    @Test
    public void getHomeworkByCourseId() {
        List<Homework> homeworkList = teacherService.getHomeworkByCourseId(1);
        for (Homework homework : homeworkList) {
            System.out.println(homework);
        }
    }

}