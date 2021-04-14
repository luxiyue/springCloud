package org.lzl.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextConfig {

//    @LoadBalanced//开启负载均衡，默认是轮循
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
//