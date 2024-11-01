package com.example.test2.dao;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.test2.model.User;

import jakarta.persistence.TypedQuery;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("deprecation")
    public void add(User user) {
        this.sessionFactory.getCurrentSession().save(user);
    }

    @SuppressWarnings("deprecation")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("select u from User u");
        return query.getResultList();
    }

    @SuppressWarnings("deprecation")
    public User getUserByCar(String model, int series) {
        String hql = "SELECT u "
                + "FROM User u "
                + "inner join Car c on u.car.id = c.id "
                + "and c.model = '"+model+"' and c.series = "+series;
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery(hql);
        return query.getSingleResult();
    }
}
