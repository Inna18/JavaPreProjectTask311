package com.inna.spring_boot.practicaltask311.service;

import com.inna.spring_boot.practicaltask311.dao.UserDao;
import com.inna.spring_boot.practicaltask311.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User findById(Long id) {
        return userDao.getOne(id);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public void saveUser(User user) {
        userDao.save(user);
    }

    @Override
    public void deleteById(Long id) {
        userDao.deleteById(id);
    }

    @Override
    @Transactional
    public User getActiveUserByEmail(String email) {
        return userDao.getActiveUserByEmail(email);
    }

    @Override
    public boolean isEmailAlreadyInUse(String email) {
        boolean emailInDB = true;

        if (userDao.getActiveUserByEmail(email) == null) {
            emailInDB = false;
        }
        return emailInDB;
    }
}
