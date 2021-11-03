package com.cloud.controller;

import com.cloud.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;


@RestController
@Slf4j
@Validated
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class MovieController {

    private static final Logger logger = LoggerFactory.getLogger(MovieController.class);
    /* @Autowired
     private RestTemplate restTemplate;*/
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private MovieService movieService;

    @GetMapping("/movie/{id}")
    public Map<String, Object> findById(@PathVariable Long id) {
        // http://localhost:7900/simple/
        // VIP virtual IP
        // HAProxy Heartbeat

        ServiceInstance serviceInstance = this.loadBalancerClient.choose("microservice-provider-user");
        System.out.println("===" + ":" + serviceInstance.getServiceId() + ":" + serviceInstance.getHost() + ":" + serviceInstance.getPort());
        logger.info("microservice-consumer-movie-ribbon-withput-eureka获取数据");
        return movieService.getUserInfo(id);
        // return this.restTemplate.getForObject("http://microservice-provider-user/simple/" + id, User.class);
    }

    @GetMapping("/test")
    public String test() {
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("microservice-provider-user");
        System.out.println("111" + ":" + serviceInstance.getServiceId() + ":" + serviceInstance.getHost() + ":" + serviceInstance.getPort());
        ServiceInstance serviceInstance2 = this.loadBalancerClient.choose("microservice-provider-users");
        System.out.println("222" + ":" + serviceInstance2.getServiceId() + ":" + serviceInstance2.getHost() + ":" + serviceInstance2.getPort());
        return "1";
    }
}
