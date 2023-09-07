package com.example.domain.service;

import com.example.domain.entity.Car;
import com.example.domain.entity.User;
import com.example.domain.port.CarRepository;
import com.example.domain.port.CarService;

import java.util.List;

public class CarServiceImpl implements CarService {

    private CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public void createCar(String brand, String model, int availableSeats, boolean isElectric, User user) {
        if (brand.isEmpty() || model.isEmpty() || availableSeats <= 0 || user.equals(null)) {
            throw new RuntimeException("Paramètre(s) invalide(s)");
        }
        Car car = new Car(brand, model, availableSeats, isElectric, user);
        carRepository.save(car);
    }

    @Override
    public Car findById(int id) {
        if (id <= 0) {
            throw new RuntimeException("ID invalide");
        }
        Car car = carRepository.findByID(id);
        return car;
    }

    @Override
    public List<Car> findAll() {
        return carRepository.findAll();
    }

    @Override
    public void delete(int id) {
        Car car = carRepository.findByID(id);
        if (id <= 0 || car.equals(null)) {
            throw new RuntimeException("Voiture introuvable");
        }
        carRepository.delete(car);
    }

    @Override
    public void update(int id, Car car) {
        if (id <= 0 || car.equals(null)) {
            throw new RuntimeException("Voiture introuvable");
        }
        Car carToUpdate = carRepository.findByID(id);

        carToUpdate.setBrand(car.getBrand());
        carToUpdate.setModel(car.getModel());
        carToUpdate.setElectric(car.isElectric());
        carToUpdate.setAvailableSeats(car.getAvailableSeats());
        carToUpdate.setUser(car.getUser());

        carRepository.save(carToUpdate);
    }
}
