package com.huangjs.dao;

import com.huangjs.domain.Homework;
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
public class HomeworkDao {
    private JdbcTemplate jdbcTemplate;
    private final String saveSql = "INSERT INTO t_homework(title, description, deadline, course_id) VALUES(?, ?, ?, ?)";
    private final String loadByCourseIdSql = "SELECT id, title, description, course_id, create_time, deadline FROM t_homework WHERE course_id=?";

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Homework homework) {
        jdbcTemplate.update(saveSql, new Object[]{homework.getTitle(), homework.getDescription(),
                        homework.getDeadline(), homework.getCourseId()},
                new int[]{Types.VARCHAR, Types.LONGVARCHAR, Types.TIMESTAMP, Types.INTEGER});
    }

    public List<Homework> loadByCourseId(int courseId) {
        List<Homework> homeworkList = new ArrayList<>();
        jdbcTemplate.query(loadByCourseIdSql, new Object[]{courseId}, new int[]{Types.INTEGER}, new RowCallbackHandler() {

            @Override
            public void processRow(ResultSet rs) throws SQLException {
                homeworkList.add(new Homework(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getInt(4), rs.getTimestamp(5), rs.getTimestamp(6)));
            }
        });
        return homeworkList;
    }
}
