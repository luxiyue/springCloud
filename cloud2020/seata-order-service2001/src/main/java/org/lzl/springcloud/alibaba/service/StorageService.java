package org.lzl.springcloud.alibaba.service;

import org.lzl.springcloud.alibaba.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * @auther zzyy
 * @create 2020-02-26 15:22
 */
@FeignClient(value = "seata-storage-service")//远程调用
public interface StorageService
{
    @PostMapping(value = "/storage/decrease")
    CommonResult decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}
