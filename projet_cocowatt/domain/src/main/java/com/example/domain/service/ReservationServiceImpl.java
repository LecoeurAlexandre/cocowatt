package com.example.domain.service;

import com.example.domain.entity.Car;
import com.example.domain.entity.Reservation;
import com.example.domain.entity.Trip;
import com.example.domain.entity.User;
import com.example.domain.port.ReservationRepository;
import com.example.domain.port.ReservationService;

import java.time.LocalDateTime;
import java.util.List;

public class ReservationServiceImpl implements ReservationService{

    private ReservationRepository reservationRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public void createReservation(User passenger, Trip trip, Car car, LocalDateTime date) {
        if (passenger.equals(null) || trip.equals(null) || car.equals(null) || date.equals(null)) {
            throw new RuntimeException("Paramètre(s) invalide(s)");
        }
        Reservation reservation = new Reservation(passenger, trip, car, date);
        reservationRepository.save(reservation);
    }

    @Override
    public Reservation findById(int id) {
        if (id <= 0) {
            throw new RuntimeException("ID invalide");
        }
        Reservation reservation = reservationRepository.findById(id);
        return reservation;
    }

    @Override
    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    @Override
    public void update(int id, Reservation reservation) {
        if (id <= 0 || reservation.equals(null)) {
            throw new RuntimeException("Réservation introuvable");
        }
        Reservation reservationToUpdate = reservationRepository.findById(id);

        reservationToUpdate.setCar(reservation.getCar());
        reservationToUpdate.setDate(reservation.getDate());
        reservationToUpdate.setPassenger(reservation.getPassenger());
        reservationToUpdate.setTrip(reservation.getTrip());

        reservationRepository.save(reservationToUpdate);
    }

    @Override
    public void delete(int id) {
        if (id <= 0) {
            throw new RuntimeException("ID invalide");
        }
        Reservation reservation = reservationRepository.findById(id);
        reservationRepository.delete(reservation);
    }
}
