package com.atguigu.gulimall.couppon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GulimallCoupponApplication {

    public static void main(String[] args) {
        SpringApplication.run(GulimallCoupponApplication.class, args);
    }

}
