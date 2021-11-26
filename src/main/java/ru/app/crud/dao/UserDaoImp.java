package ru.app.crud.dao;

import org.springframework.stereotype.Repository;
import ru.app.crud.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        TypedQuery<User> query = entityManager.createQuery("from User", User.class);
        return query.getResultList();
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public void remove(User user) {
        entityManager.remove(entityManager.merge(user));
    }

    @Override
    public User getUserById(Long id) {
        User user = entityManager.find(User.class, id);
        return user;
    }

    @Override
    public User getUserByName(String name) {
        User user = entityManager.createQuery("SELECT u FROM User u LEFT JOIN FETCH u.roles WHERE u.username=:name", User.class).setParameter("name", name).getSingleResult();
        return user;
    }
}
