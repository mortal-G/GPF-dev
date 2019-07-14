package com.chinasoft.forum.service.impl;

import com.chinasoft.forum.dal.UserRepository;
import com.chinasoft.forum.dal.entity.User;
import com.chinasoft.forum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User signIn(String email, String password) {
        User user=userRepository.findByUserEmailAndUserPassword(email,password);
        return user;
    }

    @Override
    public void signUp(User user) {
        userRepository.save(user);
    }
}
