package com.example.test2.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.test2.model.Car;

import jakarta.persistence.TypedQuery;

@Repository
public class CarDaoImpl implements CarDao {

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("deprecation")
    public void add(Car car) {
        this.sessionFactory.getCurrentSession().save(car);
    }

    @SuppressWarnings("deprecation")
    public List<Car> listCars() {
        TypedQuery<Car> query = sessionFactory.getCurrentSession().createQuery("select c from Car c");
        return query.getResultList();
    }
    
}
