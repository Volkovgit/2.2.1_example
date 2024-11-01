package com.example.test2.dao;

import java.util.List;

import com.example.test2.model.Car;

public interface CarDao {
    void add(Car car);

    List<Car> listCars();

}
