package com.itmuch.cloud.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.itmuch.cloud.entity.User;

import java.util.HashMap;
import java.util.Map;

@Api(tags = "用户操作模块API")
@RestController
public class MovieController {
    private static final Logger logger = LoggerFactory.getLogger(MovieController.class);
    @Autowired
    private RestTemplate restTemplate;

    @Value("${user.userServicePath}")
    private String userServicePath;

    @GetMapping("/movie/{id}")
    @ApiOperation(value = "根据id获取用户信息")
    public Map<String, Object> findById(@PathVariable Long id) {
        Map<String, Object> map = new HashMap<>();
        map.put("result", restTemplate.getForObject(this.userServicePath + id, Map.class));
        logger.info("调用成功返回结果");
        return map;
    }
}