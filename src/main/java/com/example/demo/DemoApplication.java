package com.example.demo;

import com.example.demo.Controller.TestLoginProxy;
import com.example.demo.Dao.EruptLogin;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import xyz.erupt.core.annotation.EruptScan;

import java.awt.*;
import java.net.URI;

@EruptLogin(TestLoginProxy.class)
@SpringBootApplication
@EntityScan
@EruptScan
public class DemoApplication extends SpringBootServletInitializer{
    public static void main(String[] args) {
//        SpringApplication.run(DemoApplication.class, args);
        ConfigurableApplicationContext run = SpringApplication.run(DemoApplication.class, args);
        ConfigurableEnvironment environment = run.getEnvironment();
        String port = environment.getProperty("local.server.port");
        try {
            System.setProperty("java.awt.headless", "false");
//            Desktop.getDesktop().browse(new URI("http://localhost:"+port));
        } catch (Exception e) {
            System.setProperty("java.awt.headless", "true");
        }
        System.err.println("详细使用方法，请阅读：README.md");
    }

    //打WAR包的配置
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(DemoApplication.class);
    }

}
