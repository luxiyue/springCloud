package org.lzl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

//该8004服务是测试zookeeper的
@SpringBootApplication
@EnableDiscoveryClient //该注解用于像使用consul 或者 zookeeper作为注册中心时注册服务 
public class PaymentMain8004 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8004.class, args);
    }
}
