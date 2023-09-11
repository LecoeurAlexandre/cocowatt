package com.example.infrastructure.entity;


import jakarta.annotation.Nullable;
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
    @Column(name="first_name", nullable=false, unique=false)
    private String firstName;
    @Column(name="last_name", nullable=false, unique=false)
    private String lastName;
    @Column(name="phone", nullable=false, unique=true)
    @Pattern(regexp = "[0-9\\s]{10}", message = "Numéro de téléphone non valide")
    private String phone;
    @Column(name="email", nullable=false, unique=true)
    @Email(message = "Adresse mail non valide")
    private String email;
    @Column(name="password", nullable=false, unique=false)
    private String password;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "trip_id")
    @Nullable
    private List<TripEntity> tripList;
    @OneToMany(fetch = FetchType.EAGER)
    @Nullable
    private List<ReservationEntity> reservationList = new ArrayList<>();
    @Column(name="isAdmin", nullable=false)
    private boolean isAdmin;
    @Column(name="image_url", nullable=true)
    private String imageUrl;
}
