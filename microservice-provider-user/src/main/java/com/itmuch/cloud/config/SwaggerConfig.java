package com.itmuch.cloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    public static final String Use_info = "用户模块";
    public static final String Use_test = "用户测试";
    @Bean
    @Profile("!prod")
    @org.jetbrains.annotations.NotNull
   public  Docket docket(){
        return  new Docket(DocumentationType.SWAGGER_2)
                .tags(new Tag(Use_info,"user相关"),
                 new Tag(Use_test,"测试")
                )
                .genericModelSubstitutes(DeferredResult.class)
                .useDefaultResponseMessages(false)
                .pathMapping("/")
                .select()
                .build()
                .apiInfo(apiInfo());
    }
    public ApiInfo  apiInfo(){
        ApiInfo apiInfo=new ApiInfo("接口文档","自定义文档描述","1.0"," ","","","");
       return apiInfo;
    }



}
