package com.hxf.bitcoin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hxf.bitcoin.dao")
public class BitcoitApplication {

    public static void main(String[] args) {
        SpringApplication.run(BitcoitApplication.class, args);
    }

}
