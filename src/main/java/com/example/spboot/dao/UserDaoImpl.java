package com.example.spboot.dao;

import com.example.spboot.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select user from User user ", User.class).getResultList();
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);

    }

    @Override
    public void deleteUser(int userId) {
        entityManager.remove(entityManager.find(User.class, userId));

    }

    @Override
    public void updateUser(int id, User userUp) {
        User user = getUser(id);
        user.setName(userUp.getName());
        user.setLastname(userUp.getLastname());
        entityManager.merge(user);

    }

    @Override
    public User getUser(int userId) {
        return entityManager.find(User.class, userId);
    }


}
