package org.lzl.springcloud.alibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @auther zzyy
 * @create 2019-12-11 16:57
 */
@Configuration
@MapperScan({"org.lzl.springcloud.alibaba.dao"})
public class MyBatisConfig {
}
