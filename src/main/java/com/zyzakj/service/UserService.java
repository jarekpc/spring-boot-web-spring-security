package com.zyzakj.service;

import com.zyzakj.model.User;

/**
 * Created by zyzakj on 2017-06-26.
 */
public interface UserService {

    public User findUserByEmail(String email);
    public void saveUser(User user);
}
