package com.asg.tcm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

import static java.lang.Math.random;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class Application extends SpringBootServletInitializer {

    private static final String NODE = "TCM-" + String.format("%03d", (int) (random() * 1000));

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    @RestController
    public static class CoreService {

        @Autowired private ConfigurationClient configuration;
        @Autowired private RepositoryAdapterClient adapter;

        @RequestMapping(path = "/document", method = GET)
        public String getDocument() {
            String repository = configuration.getRepository();
            String document = adapter.getDocument(repository);
            return NODE + "-&&-" + document;
        }
    }

}