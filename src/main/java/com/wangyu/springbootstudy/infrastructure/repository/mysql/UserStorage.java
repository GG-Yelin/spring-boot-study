package com.wangyu.springbootstudy.infrastructure.repository.mysql;

import com.wangyu.springbootstudy.domain.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserStorage {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String TABLE_NAME = "user";

    private static final String ALL_FIELD = "id, name, age";

    private static final RowMapper<User> USER_ROW_MAPPER = (rs, rowNum) -> {
        User user = new User();
        user.setId(rs.getLong("id"));
        user.setName(rs.getString("name"));
        user.setAge(rs.getInt("age"));
        return user;
    };

    public List<User> getAll() {
        String sql = String.format("select %s from %s", ALL_FIELD, TABLE_NAME);
        return jdbcTemplate.query(sql, USER_ROW_MAPPER);
    }

}
