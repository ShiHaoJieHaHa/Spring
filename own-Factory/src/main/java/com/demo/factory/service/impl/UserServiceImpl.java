package com.demo.factory.service.impl;

import com.demo.factory.dao.UserRepository;
import com.demo.factory.pojo.User;
import com.demo.factory.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private static  final Logger logger= LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserRepository userRepository;
    @Override
    public User getUserInfo(Long id) {
    if (userRepository.findById(id).isPresent()){
        logger.info("已查到想要的数据");
        return userRepository.findById(id).get();
    }
        logger.error("没有查询到想要的结果数据");
        return null;
    }
}
