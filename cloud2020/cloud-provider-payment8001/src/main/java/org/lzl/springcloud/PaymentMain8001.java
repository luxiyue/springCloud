package org.lzl.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 *
 * @author luzelong
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/3 12:11
 *
 */
@SpringBootApplication
@EnableEurekaClient//关于这个注解以后可能用的不多
@EnableDiscoveryClient//服务发现，该注解用的比较多
public class PaymentMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8001.class,args);
    }
}
