package com.example.test2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.test2.dao.CarDao;
import com.example.test2.model.Car;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarDao carDao;

    @Transactional
    @Override
    public void add(Car car) {
        carDao.add(car);
    };

    @Transactional
    @Override
    public List<Car> listCars() {
        return carDao.listCars();
    };
}