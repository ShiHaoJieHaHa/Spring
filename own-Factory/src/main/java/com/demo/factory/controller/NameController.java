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
@Api(tags = SwaggerConfig.name_info)
@Validated
@Slf4j
@RequestMapping(value = "/api/name", produces = MediaType.APPLICATION_JSON_VALUE)
public class NameController {
    private static final Logger logger = LoggerFactory.getLogger(NameController.class);
    @Autowired
    private UserService userService;

    @GetMapping("/name")
    @ApiOperation(value = "根据name获取用户信息")
    public User getUserInfo(@RequestParam @NotNull String name) {
        return userService.getUserName(name);
    }



}
