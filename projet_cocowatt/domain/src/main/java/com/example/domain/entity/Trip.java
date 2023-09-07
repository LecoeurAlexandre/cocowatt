package com.example.domain.entity;

import java.util.List;

public class Trip {
    private int id;
    private String startingPoint;
    private String endPoint;
    private int availableSeats;
    private int distance;
    private User user;
    private List<Reservation> reservationList;

    public Trip() {
    }

    public Trip(String startingPoint, String endPoint, int availableSeats, int distance, User user, List<Reservation> reservationList) {
        this.startingPoint = startingPoint;
        this.endPoint = endPoint;
        this.availableSeats = availableSeats;
        this.distance = distance;
        this.user = user;
        this.reservationList = reservationList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStartingPoint() {
        return startingPoint;
    }

    public void setStartingPoint(String startingPoint) {
        this.startingPoint = startingPoint;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Reservation> getReservationList() {
        return reservationList;
    }

    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }
}
