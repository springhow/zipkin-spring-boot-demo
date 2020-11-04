package com.springhow.examples.springboot.zipkindemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.UnknownHostException;
import java.util.Date;

@RestController
@SpringBootApplication
public class ZipkinDemoApplication {

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Value("${spring.application.name}")
    private String appName;

    @Value("${target.service.url}")
    private String target;

    @GetMapping("/hello")
    public String sayHello() {
        return appName + " to > "
                + restTemplate.getForObject(target, String.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(ZipkinDemoApplication.class, args);
    }

}
