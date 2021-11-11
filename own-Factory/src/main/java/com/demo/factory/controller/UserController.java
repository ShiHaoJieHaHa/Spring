package com.demo.factory.controller;

import com.demo.factory.config.SwaggerConfig;
import com.demo.factory.pojo.User;
import com.demo.factory.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
@Api(tags = SwaggerConfig.Use_info)
@Validated
@Slf4j
@RequestMapping(value = "/api/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;


    @GetMapping("/user")
    @ApiOperation(value = "根据id获取用户信息")
    public User getUserInfo(@RequestParam @NotNull  Long id) {
        logger.info("已查到ID对应的数据");
        return userService.getUserInfo(id);
    }
}
