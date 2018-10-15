package com.huangjs.dao;

import com.huangjs.domain.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

@Repository
public class CourseDao {
    private JdbcTemplate jdbcTemplate;
    private String loadByTeacherIdSql = "SELECT id, name, teacher_id FROM t_course WHERE teacher_id=?";
    private String saveSql = "INSERT INTO t_course(name, teacher_id) VALUES(?, ?)";

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * 获取指定教师id教授的所有课程
     *
     * @param teacherId
     * @return
     */
    public List<Course> loadByTeacherId(String teacherId) {
        return jdbcTemplate.query(loadByTeacherIdSql,
                new Object[]{teacherId},
                new int[]{Types.VARCHAR},
                new RowMapper<Course>() {
                    @Override
                    public Course mapRow(ResultSet rs, int index) throws SQLException {
                        return new Course(rs.getInt(1), rs.getString(2), rs.getString(3));
                    }
                });
    }

    /**
     * 保存课程信息
     * @param course
     */
    public void save(Course course){
        jdbcTemplate.update(saveSql, new Object[]{course.getName(),  course.getTeacherId()},
                new int[]{Types.VARCHAR, Types.VARCHAR});
    }
}
