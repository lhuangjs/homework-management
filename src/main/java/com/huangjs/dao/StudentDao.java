package com.huangjs.dao;

import com.huangjs.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StudentDao {

    private JdbcTemplate jdbcTemplate;
    private final String loadSql = "SELECT id, name, password, grade FROM t_student WHERE id=?";
    private final String loadAllSql = "SELECT id, name, password, grade FROM t_student";

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Student load(String id) {
        return jdbcTemplate.queryForObject(loadSql, new Object[]{id}, new RowMapper<Student>() {

            @Override
            public Student mapRow(ResultSet rs, int index) throws SQLException {
                return new Student(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4));
            }
        });
    }

    public List<Student> loadAll(){
        return jdbcTemplate.query(loadAllSql, new RowMapper<Student>(){

            @Override
            public Student mapRow(ResultSet rs, int index) throws SQLException {
                return new Student(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4));
            }
        });


    }
}
