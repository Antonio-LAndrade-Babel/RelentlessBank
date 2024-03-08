package com.relentlessbank.clientarea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "com.relentlessbank.clientarea")
@EntityScan("com.relentlessbank.clientarea.model")
public class ClientAreaApplication {
    public static void main (String[] args){
        SpringApplication.run(ClientAreaApplication.class, args);
    }
}