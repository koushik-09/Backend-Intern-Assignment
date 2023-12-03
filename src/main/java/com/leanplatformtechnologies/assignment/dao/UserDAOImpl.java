package com.leanplatformtechnologies.assignment.dao;

import com.leanplatformtechnologies.assignment.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO{

    private EntityManager entityManager;
    @Autowired
    public UserDAOImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }
    @Override
    public User save(User newUser) {
        User dbUser = entityManager.merge(newUser);
        return dbUser;
    }

    @Override
    public User findByPhoneNum(long phno) {
        TypedQuery<User> theQuery = entityManager.createQuery("from User WHERE phoneNum=:theData",User.class);
        theQuery.setParameter("theData",phno);
        List<User> list = theQuery.getResultList();
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<User> findAll() {
        TypedQuery<User> theQuery = entityManager.createQuery("from User",User.class);

        List<User> list = theQuery.getResultList();
        return list;
    }
}
