package com.example.springSecurity.controller;

import com.example.springSecurity.entity.UserEntity;
import com.example.springSecurity.service.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1/user")
public class UserEntityController {
    private final UserEntityService userEntityService;

    @Autowired
    public UserEntityController(UserEntityService userEntityService) {
        this.userEntityService = userEntityService;
    }

    @GetMapping
    public List<UserEntity> getAllUserEntity() {
        return userEntityService.findAll();
    }

    @GetMapping("/{id}")
    public UserEntity getUserEntityById(@PathVariable Long id) {
        return userEntityService.findById(id);
    }

    @PostMapping
    public UserEntity addUserEntity(UserEntity userEntity) {
        return userEntityService.save(userEntity);
    }

    @PutMapping("/{id}")
    public void updateUserEntity(UserEntity userEntity) {
        userEntityService.update(userEntity);
    }

    @DeleteMapping("/{id}")
    public void deleteUserEntity(@PathVariable Long id) {
        userEntityService.delete(id);
    }
}
