package com.binar.challenge4.service;

import com.binar.challenge4.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserEntity> findalluser();
    Optional<UserEntity> findById(Long id);
    UserEntity saveUser(UserEntity UserEntity);
    UserEntity updateUser(Long id,UserEntity UserEntity);
    String deleteUser(Long id);

}
