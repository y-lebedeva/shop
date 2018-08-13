package com.epam.javard.shop.repository;

import com.epam.javard.shop.dto.User;
import com.epam.javard.shop.mapper.UserMapper;
import com.epam.javard.shop.web.manager.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryJdbc {

    private static final String FIND_BY_ID_SQL = "SELECT * FROM myapp.user WHERE id = ?";
    private static final String FIND_ALL_SQL = "SELECT * FROM myapp.user";
    private static final String FIND_BY_LOGIN_AND_PASS = "SELECT * FROM myapp.user WHERE login = ? AND password = ?";
    private static final String FIND_BY_LOGIN = "SELECT * FROM myapp.user WHERE login = ?";
    private static final String DELETE_BY_ID_SQL = "DELETE FROM myapp.user WHERE id = ?";
    private static final String UPDATE_SQL = "UPDATE myapp.user SET login = ?, password = ?, role = ?, first_name = ?, last_name = ?, email = ?, phone = ? WHERE id = ?";
    private static final String INSERT_SQL = "INSERT INTO myapp.user(login, password, role, first_name, last_name, email, phone) VALUES(?, ?, ?, ?, ?, ?, ?)";

    @Autowired
    private DataSource dataSource;

    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    private void init() {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private User update(User user) {
        if (jdbcTemplate.update(UPDATE_SQL, user.getLogin(), user.getPassword(), user.getRole().getName(),
                user.getFirstName(), user.getLastName(), user.getEmail(), user.getPhone(), user.getId()) > 0) {

            return user;
        }
        return null;
    }

    private User create(User user) {

        KeyHolder generatedKeyHolder = new GeneratedKeyHolder();

        int count = jdbcTemplate.update(connection -> {
            PreparedStatement prepareStatement = connection.prepareStatement(INSERT_SQL, new String[]{"id"});
            prepareStatement.setString(1, user.getLogin());
            prepareStatement.setString(2, user.getPassword());
            prepareStatement.setString(3, user.getRole().getName());
            prepareStatement.setString(4, user.getFirstName());
            prepareStatement.setString(5, user.getLastName());
            prepareStatement.setString(6, user.getEmail());
            prepareStatement.setString(7, user.getPhone());
            return prepareStatement;
        }, generatedKeyHolder);

        if (count > 0) {

            user.setId(generatedKeyHolder.getKey().longValue());

            return user;
        }
        return null;
    }

    public User save(User user) {
        if (user.getId() != null) {
            return update(user);
        } else {
            return create(user);
        }
    }

    public void deleteById(Long id) {
        jdbcTemplate.update(DELETE_BY_ID_SQL, id);
    }

    public List<User> findAll() {
        return jdbcTemplate.query(FIND_ALL_SQL, new UserMapper());
    }

    public Optional<User> findById(Long id) {
        User user = jdbcTemplate.queryForObject(FIND_BY_ID_SQL, new Object[]{id}, new UserMapper());
        return Optional.ofNullable(user);
    }

    public User findByLoginAndPassword(String login, String password) {
        return jdbcTemplate.queryForObject(FIND_BY_LOGIN_AND_PASS, new Object[]{login, password}, new UserMapper());
    }

    public User findByLogin(String login) {
        try {
            return jdbcTemplate.queryForObject(FIND_BY_LOGIN, new Object[]{login}, new UserMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}
