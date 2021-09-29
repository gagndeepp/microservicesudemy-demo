package com.jpa.dao;

import com.jpa.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class DAOService {

    @PersistenceContext
    private EntityManager entityManager;

    public long insertUser(User user){
        entityManager.persist(user);
        return user.getId();
    }

}
