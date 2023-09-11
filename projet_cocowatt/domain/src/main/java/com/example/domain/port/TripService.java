package com.example.domain.port;

import com.example.domain.entity.Reservation;
import com.example.domain.entity.Trip;
import com.example.domain.entity.User;
import com.example.domain.exception.InvalidIdException;
import com.example.domain.exception.InvalidSeatNumberException;

import java.time.LocalDateTime;
import java.util.List;

public interface TripService {
    void create(String startingPoint, String endPoint, String startingTime, int availableSeats, int distance, int userId) throws InvalidIdException, InvalidSeatNumberException;
    Trip findById(int id) throws InvalidIdException;
    List<Trip> findAll();

    void delete(int id) throws InvalidIdException;
    void update(int id, Trip trip) throws InvalidIdException;
}
