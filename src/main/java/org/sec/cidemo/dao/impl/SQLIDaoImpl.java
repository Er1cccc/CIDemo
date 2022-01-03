package org.sec.cidemo.dao.impl;

import org.sec.cidemo.dao.SQLIDao;
import org.sec.cidemo.model.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SQLIDaoImpl implements SQLIDao {
    private final JdbcTemplate jdbcTemplate;

    public SQLIDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public String addUser(String name, int age) {
        int result = jdbcTemplate.update("insert into t_user (name,age) values (?,?)", name, age);
        if (result < 1) {
            return "error";
        }
        return "success";
    }

    @Override
    public List<User> selectUser(String name) {
        System.out.println(name);
        List<User> users = jdbcTemplate.query("select * from t_user where name=\"" + name + "\"",
                new BeanPropertyRowMapper(User.class));
        return users;
    }
}
