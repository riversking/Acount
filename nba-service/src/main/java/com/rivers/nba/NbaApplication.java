package com.rivers.nba;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@MapperScan(basePackages = {"com.rivers.nba.dao"})
@RefreshScope
@SpringBootApplication
public class NbaApplication {

    public static void main(String[] args) {
        SpringApplication.run(NbaApplication.class, args);
    }

}
