package com.example.domain.service;

import com.example.domain.entity.Car;
import com.example.domain.entity.Reservation;
import com.example.domain.entity.Trip;
import com.example.domain.entity.User;
import com.example.domain.exception.*;
import com.example.domain.port.UserRepository;
import com.example.domain.port.UserService;

import java.util.List;
import java.util.regex.Pattern;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createUser(String firstName, String lastName, String phone, String email, String password, Car car, List<Trip> tripList, List<Reservation> reservationList, boolean isAdmin, String imageUrl) throws EmptyParameterException, InvalidEmailException, InvalidPhoneException, EmailAlreadyExistsException, PhoneAlreadyExistsException {
        if (firstName.isEmpty() || lastName.isEmpty() || phone.isEmpty() || email.isEmpty() || password.isEmpty()) {
            throw new EmptyParameterException();
        }
        //Si imageUrl est vide ou incorrecte on assigne une image par défaut
        if (imageUrl.isEmpty() || !Pattern.compile("^(https?|ftp)://[^\\s/$.?#].[^\\s]*$").matcher(imageUrl).matches()) {
            imageUrl = "https://isobarscience-1bfd8.kxcdn.com/wp-content/uploads/2020/09/default-profile-picture1.jpg";
        }
        //Vérifie si l'email est valide
        if (!Pattern.compile("^(.+)@(\\S+)$").matcher(email).matches()) {
            throw new InvalidEmailException();
        }
        //Vérifie si le téléphone est valide
        if (!Pattern.compile("^0[1-9](?:\\d{2}){4}$").matcher(phone).matches()) {
            throw new InvalidPhoneException();
        }
        //Vérifie si le téléphone ou l'email est déjà utilisé
        for (User u : userRepository.findAll()) {
            if (u.getPhone().equals(phone)) {
                throw new PhoneAlreadyExistsException();
            }
            if (u.getEmail().equals(email)) {
                throw new EmailAlreadyExistsException();
            }
        }
        try {
            User user = new User(firstName, lastName, phone, email, password, car, tripList, reservationList, isAdmin, imageUrl);
            userRepository.save(user);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public User findById(int id) throws InvalidIdException, UserNotFoundException {
        if (id <= 0) {
            throw new InvalidIdException(id);
        }
        try {
            User user = userRepository.findById(id);
            return user;
        } catch (Exception e) {
            throw new UserNotFoundException();
        }
    }

    @Override
    public List<User> findAll() {
        try {
            return userRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void update(int id, User user) throws InvalidIdException, UserNotFoundException {
        if (id <= 0) {
            throw new InvalidIdException(id);
        }

        try {
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
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void delete(int id) throws InvalidIdException, UserNotFoundException {
        if (id <= 0) {
            throw new InvalidIdException(id);
        }

       try {
           User user = userRepository.findById(id);
           userRepository.delete(user);
       } catch (Exception e) {
           throw new RuntimeException(e.getMessage());
       }
    }
}