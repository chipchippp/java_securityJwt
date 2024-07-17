package com.example.springSecurity.service;

import com.example.springSecurity.entity.UserEntity;

import java.util.List;

public interface UserEntityServiceImpl {
    public List<UserEntity> findAll();
    public UserEntity findById(Long id);
    public UserEntity save(UserEntity userEntity);
    public void update(UserEntity userEntity);
    //    saveAndFlush
    public void delete(Long id);
}
