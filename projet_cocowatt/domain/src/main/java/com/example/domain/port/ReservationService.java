package com.example.domain.port;

import com.example.domain.entity.Car;
import com.example.domain.entity.Reservation;
import com.example.domain.entity.Trip;
import com.example.domain.entity.User;

import java.time.LocalDateTime;
import java.util.List;

public interface ReservationService {

    void createReservation(User passenger, Trip trip, Car car, LocalDateTime date);
    Reservation findById(int id);
    List<Reservation> findAll();
    void update(int id, Reservation reservation);
    void delete(int id);
}
