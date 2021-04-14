package org.lzl.springcloud.service;

import org.lzl.springcloud.entities.CommonResult;
import org.lzl.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE") //里面写要调用的服务名称
public interface PaymentFeignService {

    @GetMapping(value = "/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id); //该行代码复制 cloud-provider-payment8001的controller

    @GetMapping(value = "payment/feign/timeout")
    String paymentFeignTimeout();

}
