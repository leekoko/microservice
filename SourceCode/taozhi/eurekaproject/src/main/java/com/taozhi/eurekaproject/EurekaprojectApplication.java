package com.taozhi.eurekaproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaprojectApplication.class, args);
    }

}

