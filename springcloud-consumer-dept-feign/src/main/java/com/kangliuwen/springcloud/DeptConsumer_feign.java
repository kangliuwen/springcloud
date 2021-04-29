package com.kangliuwen.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author klw
 * @Description(复杂调用逻辑时的描述):
 * @date 2021-02-24 17:08
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.kangliuwen.springcloud"})
@ComponentScan("com.kangliuwen.springcloud")
public class DeptConsumer_feign {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_feign.class,args);
    }
}
