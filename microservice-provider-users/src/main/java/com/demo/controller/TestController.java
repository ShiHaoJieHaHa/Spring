package com.demo.controller;

import com.demo.config.SwaggerConfig;
import com.demo.repository.UserRepository;
import com.demo.utils.AtomicCounter;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;

@Api(tags = SwaggerConfig.Use_test)
@RestController
@Slf4j
@Validated
@RequestMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
public class TestController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserRepository userRepository;

    @ApiOperation("根据id查询用户信息")
    @GetMapping("/simple/{id}")
    public Map<String, Object> findById(@PathVariable @Validated @NotNull Long id) {
        if (userRepository.findById(id).isPresent()) {
            Map<String, Object> map = new HashMap<>();
            map.put("count", AtomicCounter.getInstance().getValue());
            map.put("user", this.userRepository.findById(id).get());
            logger.info("返回数据成功");
            return map;
        } else {
            logger.error("没有查询到id对应的数据");
        }
        return null;
    }

}
