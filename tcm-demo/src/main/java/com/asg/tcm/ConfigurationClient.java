package com.asg.tcm;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@FeignClient("configuration-demo")
public interface ConfigurationClient {

    @RequestMapping(method = GET, value = "/configuration-demo/repository")
    String getRepository();

}
