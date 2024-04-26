package com.kumararyan.contentcalendar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
//        SpringApplication.run(Application.class, args);
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
//        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        RestTemplate restTemplate = context.getBean(RestTemplate.class);
        System.out.println(restTemplate);
    }

}
