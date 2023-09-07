package com.example.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TripEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="starting_point", nullable=false, unique=false)
    private String startingPoint;
    @Column(name="end_point", nullable=false, unique=false)
    private String endPoint;
    @Column(name="starting_time", nullable=false, unique=false)
    private LocalDateTime startingTime;
    @Column(name = "available_seats", nullable = false)
    private int availableSeats;
    @Column(name="distance", nullable=false, unique=false)
    private int distance;
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;
    @OneToMany
    @JoinColumn(name = "reservation_id", nullable = false)
    private List<ReservationEntity> reservationEntityList = new ArrayList<>();

}
