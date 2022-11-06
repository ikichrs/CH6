package com.binar.challenge4.service.Impl;

import com.binar.challenge4.entity.UserEntity;
import com.binar.challenge4.repository.UserRepository;
import com.binar.challenge4.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public List<UserEntity> findalluser() {
        return userRepository.findAll();
    }

    @Override
    public Optional<UserEntity> findById(Long userid) {
        return userRepository.findById((userid));
    }

    @Override
    public UserEntity saveUser(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    @Override
    public UserEntity updateUser(Long id,UserEntity userEntity) {
        UserEntity UserEntityFINDID=userRepository.findById((id)).get();
        UserEntityFINDID.setUser_id(userEntity.getUser_id());
        UserEntityFINDID.setUsername(userEntity.getUsername());
        UserEntityFINDID.setPassword(userEntity.getPassword());
        UserEntityFINDID.setEmail(userEntity.getEmail());

        return userRepository.save(UserEntityFINDID);
    }

    @Override
    public String deleteUser(Long id) {
        userRepository.deleteById((id));
        return "User Has Been Deleted";
    }
    public List<UserEntity> getAllUser() {
        return userRepository.findAll();
    }

}
