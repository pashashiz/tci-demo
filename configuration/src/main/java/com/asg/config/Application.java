package com.asg.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.management.AttributeNotFoundException;
import javax.management.MalformedObjectNameException;

import static java.lang.Math.random;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@SpringBootApplication
@EnableEurekaClient
public class Application extends SpringBootServletInitializer {

    private static final String NODE = "CONFIG-" + String.format("%03d", (int) (random() * 1000));

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    @RestController
    public static class ConfigurationService {

        @RequestMapping(value = "/repository", method = GET)
        public String getRepository() {
            return "dummy-repository-" + NODE;
        }
    }

}

