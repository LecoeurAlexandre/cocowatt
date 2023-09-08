package com.example.domain.exception;

public class UserNotFoundException extends Exception{
    public UserNotFoundException() {
        super("Utilisateur introuvable");
    }
}
