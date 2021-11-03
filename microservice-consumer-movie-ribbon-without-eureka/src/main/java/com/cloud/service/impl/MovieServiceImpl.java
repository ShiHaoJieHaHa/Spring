package com.cloud.service.impl;

import com.cloud.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class MovieServiceImpl implements MovieService {

    private static final Logger logger = LoggerFactory.getLogger(MovieServiceImpl.class);

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Map<String, Object> getUserInfo(Long id) {
        Map<String, Object> map = new HashMap();
        map.put("user", this.restTemplate.getForObject("http://microservice-provider-user/simple/" + id, Map.class));
        logger.info("已获取到数据");
        return map;
    }
}
