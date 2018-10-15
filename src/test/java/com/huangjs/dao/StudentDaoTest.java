package com.huangjs.dao;

import com.huangjs.domain.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class StudentDaoTest {

    @Autowired
    private StudentDao studentDao;


    @Test
    public void load() {
        Student student = studentDao.load("2013212101");
        System.out.println(student);
    }

    @Test
    public void loadAll(){
        List<Student> studentList = studentDao.loadAll();
        for (Student student : studentList) {
            System.out.println(student);
        }
    }
}