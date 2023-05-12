package com.example.demo.Common;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//swagger2的配置文件，在项目的启动类的同级文件建立
@Configuration
@EnableSwagger2
//是否开启swagger，正式环境一般是需要关闭的（避免不必要的漏洞暴露）
@ConditionalOnProperty(name = "swagger.enable",havingValue = "true")
public class Swagger2 {
    //swagger2的配置文件,这里可以配置swagger2的一些基本内容，如扫描的包等
    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //为当前包路径
                .apis(RequestHandlerSelectors.basePackage("cn.xdf.springboot.controller"))
                .paths(PathSelectors.any())
                .build();
    }
    //构建api文档的详细信息函数，注意这里的注解引用的那个
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                //页面标题
                .title("Spring boot 测试使用 Swagger2构建RESTful API")
                //版本号
                .version("1.0")
                .description("API 描述")
                .contact(new Contact("Mr zhang","www.cnblogs.com/zs-notes/category/1258467.html","1729497919@qq.com"))
                .build();
    }
}
