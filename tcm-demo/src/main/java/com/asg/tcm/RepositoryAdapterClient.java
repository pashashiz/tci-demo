package com.asg.tcm;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@FeignClient("repository-adapter-demo")
public interface RepositoryAdapterClient {

    @RequestMapping(value = "repository-adapter-demo/document/{repository}", method = GET)
    String getDocument(@PathVariable("repository") String repository);

}
