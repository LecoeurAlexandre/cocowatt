package com.example.infrastructure.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="first_name", length=50, nullable=false, unique=false)
    private String firstName;
    @Column(name="last_name", length=50, nullable=false, unique=false)
    private String lastName;
    @Column(name="phone", length=10, nullable=false, unique=true)
    @Pattern(regexp = "[0-9\\s]{10}", message = "Numéro de téléphone non valide")
    private String phone;
    @Column(name="email", length=50, nullable=false, unique=true)
    @Email(message = "Adresse mail non valide")
    private String email;
    @Column(name="password", length=50, nullable=false, unique=false)
    private String password;
    @OneToOne
    @JoinColumn(name = "car_id", nullable = true)
    private CarEntity car;
    @OneToMany
    @JoinColumn(name = "trip_id", nullable = false)
    private List<TripEntity> tripEntityList;
    @OneToMany
    private List<ReservationEntity> reservationEntityList = new ArrayList<>();
    @Column(name="isAdmin", nullable=false)
    private boolean isAdmin;
    @Column(name="image_url", nullable=true)
    private String imageUrl;
}
