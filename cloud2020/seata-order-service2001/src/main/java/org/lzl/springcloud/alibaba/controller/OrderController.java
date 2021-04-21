package org.lzl.springcloud.alibaba.controller;


import org.lzl.springcloud.alibaba.domain.CommonResult;
import org.lzl.springcloud.alibaba.domain.Order;
import org.lzl.springcloud.alibaba.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @auther zzyy
 * @create 2020-02-26 15:24
 */
@RestController
public class OrderController
{
    @Resource
    private OrderService orderService;


    @GetMapping("/order/create")//http://localhost:2001/order/create?userId=1&productId=1&count=10&money=100
    public CommonResult create(Order order)
    {
        orderService.create(order);
        return new CommonResult(200,"订单创建成功");
    }
}
