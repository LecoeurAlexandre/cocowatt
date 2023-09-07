package com.example.domain.service;

import com.example.domain.entity.Reservation;
import com.example.domain.entity.Trip;
import com.example.domain.entity.User;
import com.example.domain.port.TripRepository;
import com.example.domain.port.TripService;

import java.util.List;

public class TripServiceImpl implements TripService {

    private TripRepository tripRepository;

    public TripServiceImpl(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    @Override
    public void save(String startingPoint, String endPoint, int availableSeats, int distance, User user, List<Reservation> reservationList) {
        if (startingPoint.isEmpty() || endPoint.isEmpty() || availableSeats <= 0 || user.equals(null)) {
            throw new RuntimeException("Paramètre(s) invalide(s)");
        }
        Trip trip = new Trip(startingPoint, endPoint, availableSeats, distance, user, reservationList);
        tripRepository.save(trip);
    }

    @Override
    public Trip findById(int id) {
        if (id <= 0) {
            throw new RuntimeException("ID invalide");
        }
        Trip trip = tripRepository.findById(id);
        return trip;
    }

    @Override
    public List<Trip> findAll() {
        return tripRepository.findAll();
    }

    @Override
    public void delete(int id) {
        Trip trip = tripRepository.findById(id);
        if (id <= 0 || trip.equals(null)) {
            throw new RuntimeException("Trajet introuvable");
        }
        tripRepository.delete(trip);
    }

    @Override
    public void update(int id, Trip trip) {
        if (id <= 0 || trip.equals(null)) {
            throw new RuntimeException("Trajet introuvable");
        }
        Trip tripToUpdate = tripRepository.findById(id);

        tripToUpdate.setStartingPoint(trip.getStartingPoint());
        tripToUpdate.setEndPoint(trip.getEndPoint());
        tripToUpdate.setAvailableSeats(trip.getAvailableSeats());
        tripToUpdate.setDistance(trip.getDistance());
        tripToUpdate.setUser(trip.getUser());
        tripToUpdate.setReservationList(trip.getReservationList());

        tripRepository.save(tripToUpdate);
    }
}
