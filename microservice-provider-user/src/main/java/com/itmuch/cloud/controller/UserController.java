package com.itmuch.cloud.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.itmuch.cloud.config.SwaggerConfig;
import com.itmuch.cloud.service.UserService;
import com.itmuch.cloud.utils.AtomicCounter;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.google.common.collect.Lists;
import com.itmuch.cloud.entity.User;
import com.itmuch.cloud.repository.UserRepository;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import javax.validation.constraints.NotNull;
@Api(tags = SwaggerConfig.Use_info)
@Slf4j
@Validated
@RestController
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EurekaClient eurekaClient;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private UserService service;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @ApiOperation("根据id查询用户信息")
    @GetMapping("/simple/{id}")
    public Map<Object, Object> findById(@PathVariable Long id) {
        Map<Object, Object> map = new HashMap<>();
        logger.info("调用findById方法");
        if (userRepository.findById(id).isPresent()) {
            map.put("count", AtomicCounter.getInstance().getValue());
            map.put("user", this.userRepository.findById(id).get());
            return map;
        } else {
            logger.error("没有查询到该id对应的数据");
        }
        return null;
    }
    @ApiOperation("查询用户信息")
    @GetMapping("/service")
    public User findId(@RequestParam @NotNull Long id) {
        return service.findById(id);
    }

    @ApiOperation("查询调用的实例名称")
    @GetMapping("/eureka-instance")
    public String serviceUrl() {
        InstanceInfo instance = this.eurekaClient.getNextServerFromEureka("MICROSERVICE-PROVIDER-USER", false);
        return instance.getHomePageUrl();
    }

    @GetMapping("/instance-info")
    public List<String> showInfo() {
        //ServiceInstance localServiceInstance = this.discoveryClient.getLocalServiceInstance();
        List<String> localServiceInstance = discoveryClient.getServices();
        return localServiceInstance;
    }

    // 该请求不会成功
    @GetMapping("/get-user")
    public User getUser(User user) {
        return user;
    }

    @GetMapping("list-all")
    public List<User> listAll() {
        ArrayList<User> list = Lists.newArrayList();
        User user = new User(1L, "zhangsan");
        User user2 = new User(2L, "zhangsan");
        User user3 = new User(3L, "zhangsan");
        list.add(user);
        list.add(user2);
        list.add(user3);
        return list;
    }
}
