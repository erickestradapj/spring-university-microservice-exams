package com.dev.microservices.app.exams;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.dev.microservices.commons.exams.models.entity"})
public class MicroserviceExamsApplication {
    public static void main(String[] args) {
        SpringApplication.run(MicroserviceExamsApplication.class, args);
    }
}
