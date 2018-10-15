package com.huangjs.dao;

import com.huangjs.domain.TeachingClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TeachingClassDao {
    private JdbcTemplate jdbcTemplate;
    private final String saveSql = "INSERT INTO t_teaching_class(name, course_id) VALUES(?, ?)";
    private final String loadByCourseIdSql = "SELECT id, name, course_id FROM t_teaching_class WHERE teaching_id=?";

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(TeachingClass teachingClass) {
        jdbcTemplate.update(saveSql, new Object[]{teachingClass.getName(), teachingClass.getCourseId()},
                new int[]{Types.VARCHAR, Types.INTEGER});
    }

    /**
     * 通过课程id获取有该课程的班级信息
     *
     * @param courseId 课程id
     * @return
     */
    public List<TeachingClass> loadByCourseId(int courseId) {
        final List<TeachingClass> teachingClassList = new ArrayList<>();
        jdbcTemplate.query(loadByCourseIdSql, new Object[]{courseId}, new int[]{Types.INTEGER}, new RowCallbackHandler() {

            @Override
            public void processRow(ResultSet rs) throws SQLException {
                teachingClassList.add(new TeachingClass(rs.getInt(1), rs.getString(2),
                        rs.getInt(3)));
            }
        });
        return teachingClassList;
    }
}
