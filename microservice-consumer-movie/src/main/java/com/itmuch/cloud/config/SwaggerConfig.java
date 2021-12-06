package com.itmuch.cloud.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.core.env.Profiles;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
  @Bean
    public Docket docketUser() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("MicroserviceSimpleConsumerMovieApplication");
    }


    @Bean
    public Docket docket(Environment environment) {
        List<ResponseMessage> responseMessageList = new ArrayList<>();
        Arrays.stream(RestResponseCode.values()).forEach(stateCodeEnum ->
        {
            responseMessageList.add(
                    /*new ResponseMessageBuilder()
                            .code(stateCodeEnum.getCode())
                            .message(stateCodeEnum.getMsg())
                            .responseModel(new ModelRef(stateCodeEnum.getMsg()))
                            .build());//这种形式swagger提示自定义返回msg找不到*/
                    new ResponseMessageBuilder()
                            .code(stateCodeEnum.getCode())
                            .message(stateCodeEnum.getMsg())
                            .build());
        });
        //设置要显示的Swagger环境
        Profiles profiles = Profiles.of("dev");
        //获取项目环境：是生产环境还是发布环境
        boolean flag = environment.acceptsProfiles(profiles);
        return new Docket(DocumentationType.SWAGGER_2)
                //添加全局状态码
                .globalResponseMessage(RequestMethod.GET, responseMessageList)
                .globalResponseMessage(RequestMethod.POST, responseMessageList)
                .globalResponseMessage(RequestMethod.PUT, responseMessageList)
                .globalResponseMessage(RequestMethod.DELETE, responseMessageList)
                .apiInfo(apiInfo())
                .groupName("")
                .enable(flag)//是否启用swagger，如果为false则swagger不能再浏览器中访问
                .select()//通过select()方法配置扫描接口,RequestHandlerSelectors配置如何扫描接口
                //指定扫描的api包
                .apis(RequestHandlerSelectors.basePackage("com.itmuch.cloud.controller"))
                //.paths(PathSelectors.ant("/sys/**"));//通过paths()方法配置扫描接口,PathSelectors配置如何扫描接口
                .build();
    }

    public ApiInfo apiInfo() {
        Contact contact = new Contact("api", "", "");
        return new ApiInfo(
                "接口文档",
                "自定义文档描述",
                "1.0",
                " ",
                contact,
                "",
                "",
                new ArrayList());
    }


}
