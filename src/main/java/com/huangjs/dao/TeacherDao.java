package com.huangjs.dao;

import com.huangjs.domain.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

@Repository
public class TeacherDao {
    private JdbcTemplate jdbcTemplate;
    private String loadSql = "SELECT id, name, password FROM t_teacher WHERE id=?";

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Teacher load(String id) {
        return jdbcTemplate.queryForObject(loadSql, new Object[]{id}, new int[]{Types.VARCHAR}, new RowMapper<Teacher>() {

            @Override
            public Teacher mapRow(ResultSet rs, int index) throws SQLException {
                return new Teacher(rs.getString(1), rs.getString(2), rs.getString(3));
            }
        });
    }
}
