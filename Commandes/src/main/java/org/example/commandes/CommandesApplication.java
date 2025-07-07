package org.example.commandes;
import org.springframework.boot.SpringApplication;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import org.springframework.boot.autoconfigure.SpringBootApplication;
@EnableEurekaClient
@SpringBootApplication
public class CommandesApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommandesApplication.class, args);
    }

}
