package com.huangjs.service;

import com.huangjs.dao.CourseDao;
import com.huangjs.dao.HomeworkDao;
import com.huangjs.dao.TeacherDao;
import com.huangjs.dao.TeachingClassDao;
import com.huangjs.domain.Course;
import com.huangjs.domain.Homework;
import com.huangjs.domain.Teacher;
import com.huangjs.domain.TeachingClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherDao teacherDao;

    @Autowired
    private CourseDao courseDao;

    @Autowired
    private TeachingClassDao teachingClassDao;

    @Autowired
    private HomeworkDao homeworkDao;


    @Override
    public void createCourse(Course course) {
        courseDao.save(course);
    }

    @Override
    public void createTeachingClass(TeachingClass teachingClass) {
        teachingClassDao.save(teachingClass);
    }

    @Override
    public void createHomework(Homework homework) {
        homeworkDao.save(homework);
    }

    @Override
    public Teacher getTeacherById(String id) {
        return teacherDao.load(id);
    }

    @Override
    public List<Course> getCourseByTeacherId(String teacherId) {
        return courseDao.loadByTeacherId(teacherId);
    }

    @Override
    public List<Homework> getHomeworkByCourseId(int courseId) {
        return homeworkDao.loadByCourseId(courseId);
    }
}
