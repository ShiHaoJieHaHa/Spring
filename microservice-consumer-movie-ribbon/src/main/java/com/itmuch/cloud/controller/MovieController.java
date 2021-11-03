package com.itmuch.cloud.controller;


import com.itmuch.cloud.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.Map;

@RestController
public class MovieController {
    private static final Logger logger = LoggerFactory.getLogger(MovieController.class);
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private MovieService movieService;
    // @Value("${user.userServicePath}")
    // private String userServicePath;
    @Autowired
    private LoadBalancerClient loadBalancerClient;


    // http://localhost:7900/simple/
    // VIP virtual IP   虚拟ip
    // HAProxy Heartbeat
    @GetMapping("/movie/{id}")
    public Map<String, Object> findById(@PathVariable Long id) {
        //return this.restTemplate.getForObject(this.userServicePath + id, User.class);
       /* Map<String, Object> map = new HashMap<>();
        map.put("user", this.restTemplate.getForObject("http://microservice-provider-user/simple/" + id, Map.class));
        */
        logger.info("ribbon服务已获取到数据");
        return movieService.getUserInfo(id);
        //       return this.restTemplate.getForObject("http://microservice-provider-user/simple/" + id, User.class);
    }

    @GetMapping("/test")
    public String test() {
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("microservice-provider-user");
        System.out.println("111" + ":" + serviceInstance.getHost() + ":" + serviceInstance.getServiceId() + ":" + serviceInstance.getPort());
        ServiceInstance serviceInstance2 = this.loadBalancerClient.choose("microservice-provider-users");
        System.out.println("222" + ":" + serviceInstance2.getServiceId() + ":" + serviceInstance2.getHost() + ":" + serviceInstance2.getPort());
        return "1";
    }
}
