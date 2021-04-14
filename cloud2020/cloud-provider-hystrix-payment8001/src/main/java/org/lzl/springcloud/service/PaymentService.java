package org.lzl.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {


    ///！！！下面是服务降级

    public String paymentInfo_OK(Integer id){//正常访问，肯定ok的代码
        return "线程池：   "+Thread.currentThread().getName()+"  paymentInfo_OK  *****  id:    "+id+"\t"+"O(n_n)O哈哈~";
    }


    //服务降级第二步
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })//想要实现服务降级就得加上该注解,括号里面写兜底的方法
    public String paymentInfo_TimeOut(Integer id){
//        int age = 10/0;
        int timeNumber=3;
        //暂停几秒钟线程
        try{TimeUnit.SECONDS.sleep(timeNumber);}catch (InterruptedException e){e.printStackTrace();}
        return "线程池：   "+Thread.currentThread().getName()+"  paymentInfo_TimeOut  *****  id:    "+id+"\t"+"O(n_n)O哈哈~"+"   耗时:"+timeNumber+"秒钟！";
    }
    public String paymentInfo_TimeOutHandler(Integer id){
        return "线程池：   "+Thread.currentThread().getName()+"  paymentInfo_TimeOutHandler  *****  id:    "+id+"\t"+"O(+~+)O哎哎哎~"+"<br/>系统繁忙或者运行报错，请稍后再试！！！";
    }



    ////！！！！！！！！！！！！！！下面是服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),// 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),// 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")// 失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if(id < 0) {
            throw new RuntimeException("******id 不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"\t"+"调用成功，流水号: " + serialNumber;
    }
    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id) {
        return "id 不能负数，请稍后再试，/(ㄒoㄒ)/~~   id: " +id;
    }

}
