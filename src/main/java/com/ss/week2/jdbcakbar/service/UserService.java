package com.ss.week2.jdbcakbar.service;


import com.ss.week2.jdbcakbar.dao.UserDao;
import com.ss.week2.jdbcakbar.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public class UserService {
    private UserDao userDao;
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }
    public int createUser(User user) throws SQLException, ClassNotFoundException {
        return userDao.createUser(user);
    }

    public User getUser(int userId) throws SQLException, ClassNotFoundException {
        return userDao.getUserById(userId);
    }


}
