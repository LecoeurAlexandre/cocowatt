package com.example.adapters.controller;

import com.example.adapters.entity.UserDtoRequest;
import com.example.adapters.entity.UserDtoResponse;
import com.example.domain.entity.User;
import com.example.domain.exception.EmptyParameterException;
import com.example.domain.exception.InvalidIdException;
import com.example.domain.exception.EntityNotFoundException;
import com.example.domain.port.UserService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("")
    public ResponseEntity post(@Valid @RequestBody UserDtoRequest userDtoRequest) throws EmptyParameterException {
        try {
            userService.createUser(
                    userDtoRequest.getFirstName(),
                    userDtoRequest.getLastName(),
                    userDtoRequest.getPhone(),
                    userDtoRequest.getEmail(),
                    userDtoRequest.getPassword(),
                    userDtoRequest.getTripList(),
                    userDtoRequest.getReservationList(),
                    userDtoRequest.isAdmin(),
                    userDtoRequest.getImageUrl()
            );
            return ResponseEntity.status(HttpStatus.CREATED).body("Utilisateur créé");
        } catch (Exception e ) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("")
    public ResponseEntity getAll() {
        List<UserDtoResponse> userDtoResponseList = new ArrayList<>();
        for (User u : userService.findAll()) {
            UserDtoResponse userDtoResponse = modelMapper.map(u, UserDtoResponse.class);
            userDtoResponseList.add(userDtoResponse);
        }
        return ResponseEntity.ok(userDtoResponseList);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity getById(@PathVariable int id) throws EntityNotFoundException, InvalidIdException {
        try {
            UserDtoResponse userDtoResponse = modelMapper.map(userService.findById(id), UserDtoResponse.class);
            return ResponseEntity.ok(userDtoResponse);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/lastname/{lastName}")
    public ResponseEntity getAllByLastName(@PathVariable String lastName) {
        try {
            List<UserDtoResponse> userDtoResponseList = new ArrayList<>();
            for (User u : userService.findAllByLastName(lastName)) {
                UserDtoResponse userDtoResponse = modelMapper.map(u, UserDtoResponse.class);
                userDtoResponseList.add(userDtoResponse);
            }
            return ResponseEntity.ok(userDtoResponseList);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable int id, @RequestBody UserDtoRequest userDtoRequest) throws EntityNotFoundException, InvalidIdException {
        try {
            User user = modelMapper.map(userDtoRequest, User.class);
            userService.update(id, user);
            return ResponseEntity.ok("Utilisateur mis à jour");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        try {
            userService.delete(id);
            return ResponseEntity.ok("Utilisateur supprimé");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
