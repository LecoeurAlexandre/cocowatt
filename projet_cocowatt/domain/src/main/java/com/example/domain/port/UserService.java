package com.example.domain.port;

import com.example.domain.entity.Car;
import com.example.domain.entity.Reservation;
import com.example.domain.entity.Trip;
import com.example.domain.entity.User;
import com.example.domain.exception.*;

import java.util.List;

public interface UserService {
    void createUser(String firstName, String lastName, String phone, String email, String password, List<Trip> tripList, List<Reservation> reservationList, boolean isAdmin, String imageUrl) throws EmptyParameterException, InvalidEmailException, InvalidPhoneException, EmailAlreadyExistsException, PhoneAlreadyExistsException;
    User findById(int id) throws InvalidIdException, EntityNotFoundException;
    List<User> findAll();
    void update(int id, User user) throws InvalidIdException, EntityNotFoundException;
    void delete(int id) throws InvalidIdException, EntityNotFoundException;
    List<User> findAllByLastName(String lastName);
}
