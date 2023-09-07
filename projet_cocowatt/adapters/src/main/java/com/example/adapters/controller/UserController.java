package com.example.adapters.controller;

import com.example.adapters.entity.UserDtoRequest;
import com.example.adapters.entity.UserDtoResponse;
import com.example.domain.entity.User;
import com.example.domain.port.UserService;
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
    public ResponseEntity post(@RequestBody UserDtoRequest userDtoRequest) {
        userService.createUser(
                userDtoRequest.getFirstName(),
                userDtoRequest.getFirstName(),
                userDtoRequest.getPhone(),
                userDtoRequest.getEmail(),
                userDtoRequest.getPassword(),
                userDtoRequest.getCar(),
                userDtoRequest.getTripList(),
                userDtoRequest.getReservationList(),
                userDtoRequest.isAdmin(),
                userDtoRequest.getImageUrl()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body("Utilisateur créé");
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

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable int id) {
        UserDtoResponse userDtoResponse = modelMapper.map(userService.findById(id), UserDtoResponse.class);
        return ResponseEntity.ok(userDtoResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable int id, @RequestBody UserDtoRequest userDtoRequest) {
        User user = modelMapper.map(userDtoRequest, User.class);
        userService.update(id, user);
        return ResponseEntity.ok("Utilisateur mis à jour");
    }

    public ResponseEntity delete(int id) {
        userService.delete(id);
        return ResponseEntity.ok("Utilisateur supprimé");
    }

}
