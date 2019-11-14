package com.hxf.bitcoin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.hxf.bitcoin.dao")
//@EnableScheduling
@EnableFeignClients
@EnableDiscoveryClient
@EnableAsync
public class BitcoitApplication {

    public static void main(String[] args) {
        SpringApplication.run(BitcoitApplication.class, args);
    }

}
