package com.endava.internship;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
@SpringBootApplication
@EntityScan
public class InternshipJavaApplication {
    public static void main(String[] args) {
        SpringApplication.run(InternshipJavaApplication.class, args);
    }
}
