package com.example.domain.service;

import com.example.domain.entity.Car;
import com.example.domain.entity.Reservation;
import com.example.domain.entity.Trip;
import com.example.domain.entity.User;
import com.example.domain.port.UserRepository;
import com.example.domain.port.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createUser(String firstName, String lastName, String phone, String email, String password, Car car, List<Trip> tripList, List<Reservation> reservationList, boolean isAdmin, String imageUrl) {
        if (firstName.isEmpty() || lastName.isEmpty() || phone.isEmpty() || email.isEmpty() || password.isEmpty()) {
            throw new RuntimeException("Paramètre(s) invalide(s)");
        }
        User user = new User(firstName, lastName, phone, email, password, car, tripList, reservationList, isAdmin, imageUrl);
        userRepository.save(user);
    }

    @Override
    public User findById(int id) {
        if (id <= 0) {
            throw new RuntimeException("ID invalide");
        }
        User user = userRepository.findById(id);
        return user;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void update(int id, User user) {
        if (id <= 0 || user.equals(null)) {
            throw new RuntimeException("Utilisateur introuvable");
        }
        User userToUpdate = userRepository.findById(id);

        userToUpdate.setFirstName(user.getFirstName());
        userToUpdate.setLastName(user.getLastName());
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setPassword(user.getPassword());
        userToUpdate.setPhone(user.getPhone());
        userToUpdate.setAdmin(user.isAdmin());
        userToUpdate.setCar(user.getCar());
        userToUpdate.setReservationList(user.getReservationList());
        userToUpdate.setTripList(user.getTripList());
        userToUpdate.setImageUrl(user.getImageUrl());

        userRepository.save(userToUpdate);
    }

    @Override
    public void delete(int id) {
        User user = userRepository.findById(id);
        if (id <= 0 || user.equals(null)) {
            throw new RuntimeException("Utilisateur introuvable");
        }
        userRepository.delete(user);
    }
}
