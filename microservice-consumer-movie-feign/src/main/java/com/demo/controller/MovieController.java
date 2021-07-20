package com.demo.controller;


import com.demo.entity.User;
import com.demo.feign.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MovieController {
/*    @Autowired
    private RestTemplate restTemplate;

    @Value("${user.userServicePath}")
    private String userServicePath;*/


    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("/movie/{id}")
    public User findById(@PathVariable Long id) {
        //return this.restTemplate.getForObject(this.userServicePath + id, User.class);
        return this.userFeignClient.findById(id);
    }

    @GetMapping("/test")
    public User testPost(User user) {
        return this.userFeignClient.postUser(user);
    }

}
