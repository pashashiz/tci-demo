package com.asg.adapter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.lang.Math.random;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@SpringBootApplication
@EnableEurekaClient
public class Application {

    private static final String NODE = "ADAPTER-" + String.format("%03d", (int) (random() * 1000));

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @RestController
    public static class DocumentService {

        @RequestMapping(value = "/document/{repository}", method = GET)
        public String getDocument(@PathVariable("repository") String repository) {
            return repository + "-&&-" + "document-" + NODE;
        }
    }

}
