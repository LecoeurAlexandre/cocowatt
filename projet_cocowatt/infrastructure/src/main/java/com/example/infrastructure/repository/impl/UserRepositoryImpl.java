package com.example.infrastructure.repository.impl;

import com.example.domain.entity.User;
import com.example.domain.port.UserRepository;
import com.example.infrastructure.entity.UserEntity;
import com.example.infrastructure.repository.UserEntityRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private final ModelMapper modelMapper;
    private final UserEntityRepository userEntityRepository;

    public UserRepositoryImpl(ModelMapper modelMapper, UserEntityRepository userEntityRepository) {
        this.modelMapper = modelMapper;
        this.userEntityRepository = userEntityRepository;
    }

    @Override
    public void save(User user) {
        UserEntity userEntity = modelMapper.map(user, UserEntity.class);
        userEntityRepository.save(userEntity);
    }

    @Override
    public User findById(int id) {
        User user = modelMapper.map(userEntityRepository.findById(id), User.class);
        return user;
    }

    @Override
    public List<User> findAll() {
        List<UserEntity> userEntityList = (List<UserEntity>) userEntityRepository.findAll();
        List<User> userList = new ArrayList<>();
        for (UserEntity u : userEntityList) {
            User user = modelMapper.map(u, User.class);
            userList.add(user);
        }
        return userList;
    }

    @Override
    public void delete(User user) {
        UserEntity userEntity = modelMapper.map(user, UserEntity.class);
        userEntityRepository.delete(userEntity);
    }
}
