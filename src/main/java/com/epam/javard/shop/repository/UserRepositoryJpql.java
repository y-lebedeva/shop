package com.epam.javard.shop.repository;

import com.epam.javard.shop.dto.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserRepositoryJpql {

    @PersistenceContext
    private EntityManager entityManager;

    public List<User> findAll() {
        Query query = entityManager.createNativeQuery("SELECT * FROM myapp.user");
        return query.getResultList();
    }

    public User gtUserById(Long id) {
        return entityManager.find(User.class, id);
    }

}
