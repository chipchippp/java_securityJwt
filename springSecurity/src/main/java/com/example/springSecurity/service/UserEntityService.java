package com.example.springSecurity.service;

import com.example.springSecurity.entity.UserEntity;
import com.example.springSecurity.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserEntityService implements UserEntityServiceImpl{
    private final UserRepository userRepository;

    @Autowired
    public UserEntityService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public UserEntity save(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    @Override
    public void update(UserEntity userEntity) {
        UserEntity userEntity1 = userRepository.findById(userEntity.getId()).orElse(null);
        if (userEntity1 != null) {
            userEntity1.setUsername(userEntity.getUsername());
            userEntity1.setPassword(userEntity.getPassword());
            userEntity1.setRoles(userEntity.getRoles());
            userRepository.save(userEntity1);
        }
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
