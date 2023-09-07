package com.example.domain.port;

import com.example.domain.entity.Reservation;
import com.example.domain.entity.Trip;
import com.example.domain.entity.User;

import java.util.List;

public interface TripService {
    void save(String startingPoint, String endPoint, int availableSeats, int distance, User user, List<Reservation> reservationList);
    Trip findById(int id);
    List<Trip> findAll();

    void delete(int id);
    void update(int id, Trip trip);
}
