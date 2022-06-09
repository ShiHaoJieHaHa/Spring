package com.demo.factory.service;

import com.demo.factory.pojo.User;

public interface UserService {
    User getUserInfo(Long id);
    User getUserName(String name);
}
