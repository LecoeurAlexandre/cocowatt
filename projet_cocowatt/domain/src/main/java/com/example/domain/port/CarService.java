package com.example.domain.port;

import com.example.domain.entity.Car;
import com.example.domain.entity.User;

import java.util.List;

public interface CarService {

    void createCar(String brand, String model, int availableSeats, boolean isElectric, User user);
    Car findById(int id);
    List<Car> findAll();
    void delete(int id);
    void update(int id, Car car);
}
