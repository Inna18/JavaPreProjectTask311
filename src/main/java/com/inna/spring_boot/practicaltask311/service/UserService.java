package com.inna.spring_boot.practicaltask311.service;

import com.inna.spring_boot.practicaltask311.model.User;

import java.util.List;

public interface UserService {

    public User findById(Long id);

    public List<User> findAll();

    public void saveUser(User user);

    public void deleteById(Long id);

    User getActiveUserByEmail(String email);

    public boolean isEmailAlreadyInUse(String email);
}
