package com.rooture.service;

import com.rooture.dao.UserDAO;
import com.rooture.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public void registerUser(User user) {
        userDAO.saveUser(user);
    }
}