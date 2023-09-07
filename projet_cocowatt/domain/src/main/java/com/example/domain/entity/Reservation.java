package com.example.domain.entity;

import java.time.LocalDateTime;

public class Reservation {
    private int id;
    private User passenger;
    private Trip trip;
    private Car car;
    private LocalDateTime date;

    public Reservation() {
    }

    public Reservation(User passenger, Trip trip, Car car, LocalDateTime date) {
        this.passenger = passenger;
        this.trip = trip;
        this.car = car;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getPassenger() {
        return passenger;
    }

    public void setPassenger(User passenger) {
        this.passenger = passenger;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
