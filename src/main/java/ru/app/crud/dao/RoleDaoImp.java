package ru.app.crud.dao;

import org.springframework.beans.factory.annotation.Autowired;
import ru.app.crud.model.Role;

import javax.persistence.EntityManager;

public class RoleDaoImp implements RoleDao{
    EntityManager entityManager;

    @Autowired
    public RoleDaoImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(Role role) {

    }
}
