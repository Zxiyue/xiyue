package com.example.demo.config;


import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

/**
 * ClassName: Knife4JConfig
 */

@Configuration
@EnableSwagger2
@EnableKnife4j
@Import(BeanValidatorPluginsConfiguration.class)
@ConditionalOnProperty(value = {"knife4j.enable"},matchIfMissing = true)
@EnableSwagger2WebMvc
public class Knife4JConfig {
    /**
     * @param
     * @return Docket
     * @description knife4j配置类
     * 前台API分组
     * @author lixin
     * @date 2021/5/6 13:54
     */
    @Bean(value = "indexApi")
    public Docket indexApi() {
        Docket fdocket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                //分组名称
                .groupName("前台API")
                .select()
                //这里指定Controller扫描包路径(项目路径也行)
                .apis(RequestHandlerSelectors.basePackage("xyz.erupt"))
                .paths(PathSelectors.any())
                .build();
        return fdocket;
    }

    /**
     * 后台API分组
     * @return
     */
    @Bean(value = "admimAPI")
    public Docket adminApi(){
        Docket ldocket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                //分组名称
                .groupName("后台API")
                .select()
                //这里指定Controller扫描包路径(项目路径也行)
                .apis(RequestHandlerSelectors.basePackage("com.example.demo.conyroller"))
                .paths(PathSelectors.any())
                .build();
        return ldocket;
    }

    /**
     * @param
     * @return ApiInfo
     * @description 接口文档信息
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("在线API接口文档")
                .description("API接口在线文档")
                .version("1.0")
                .build();
    }
}
