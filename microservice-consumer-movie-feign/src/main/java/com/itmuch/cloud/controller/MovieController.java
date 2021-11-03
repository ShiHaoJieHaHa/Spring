package com.itmuch.cloud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.itmuch.cloud.entity.User;
import com.itmuch.cloud.feign.UserFeignClient;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MovieController {
    private static  final Logger logger = LoggerFactory.getLogger(MovieController.class);
  @Autowired
  private UserFeignClient userFeignClient;

  @GetMapping("/movie/{id}")
  public Map<String, Object> findById(@PathVariable Long id) {
    Map<String,Object> map=new HashMap<>();
    map.put("user",this.userFeignClient.findById(id));
    logger.info("feign调用到服务提供的数据");
    return map;
  }

  @GetMapping("/user")
  public User testPost(User user) {
    return this.userFeignClient.postUser(user);
  }

  @GetMapping("/test-get")
  public User testGet(User user) {
    return this.userFeignClient.getUser(user);
  }
}
