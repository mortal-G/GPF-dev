package com.chinasoft.forum.service;

import com.chinasoft.forum.dal.entity.User;

public interface UserService {

    User signIn(String email,String password);

    void signUp(User user);
}
