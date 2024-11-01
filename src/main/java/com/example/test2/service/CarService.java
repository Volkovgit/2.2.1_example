package com.example.test2.service;
import java.util.List;

import com.example.test2.model.Car;
import com.example.test2.model.User;

public interface CarService {
    void add(Car car);
    List<Car> listCars();
}