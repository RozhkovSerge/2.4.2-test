package ru.app.crud.dao;

import org.springframework.beans.factory.annotation.Autowired;
import ru.app.crud.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class RoleDaoImp implements RoleDao{
    EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(Role role) {

    }
}
