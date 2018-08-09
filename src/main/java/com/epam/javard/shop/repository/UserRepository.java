package com.epam.javard.shop.repository;

import com.epam.javard.shop.dto.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByLoginAndPassword(String login, String password);

    User findByLogin(String login);
}
