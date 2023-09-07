package com.example.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReservationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(nullable = false)
    private UserEntity passenger;
    @ManyToOne
    @JoinColumn(nullable = false)
    private TripEntity trip;
    @ManyToOne
    @JoinColumn(nullable = false)
    private CarEntity car;
    @Column(name = "reservation_date")
    private LocalDateTime date = LocalDateTime.now();
}
