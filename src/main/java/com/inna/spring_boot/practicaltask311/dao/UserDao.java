package com.inna.spring_boot.practicaltask311.dao;

import com.inna.spring_boot.practicaltask311.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
    User getActiveUserByEmail(String email);
}
