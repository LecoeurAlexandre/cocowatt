package com.example.domain.port;

import com.example.domain.entity.Car;
import com.example.domain.entity.Reservation;
import com.example.domain.entity.Trip;
import com.example.domain.entity.User;

import java.util.List;

public interface UserService {
    void createUser(String firstName, String lastName, String phone, String email, String password, Car car, List<Trip> tripList, List<Reservation> reservationList, boolean isAdmin, String imageUrl);
    User findById(int id);
    List<User> findAll();
    void update(int id, User user);
    void delete(int id);
}
