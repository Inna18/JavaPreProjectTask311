package com.inna.spring_boot.practicaltask311.service;

import com.inna.spring_boot.practicaltask311.dao.UserDao;
import com.inna.spring_boot.practicaltask311.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public User findById(Long id) {
        return userDao.getOne(id);
    }

    public List<User> findAll() {
        return userDao.findAll();
    }

    public void saveUser(User user) {
        userDao.save(user);
    }

    public void deleteById(Long id) {
        userDao.deleteById(id);
    }

}
