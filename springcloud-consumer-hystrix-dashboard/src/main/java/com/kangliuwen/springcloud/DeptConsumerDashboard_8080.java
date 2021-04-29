package com.kangliuwen.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author klw
 * @Description(复杂调用逻辑时的描述):
 * @date 2021-02-26 21:59
 */
@SpringBootApplication
@EnableHystrixDashboard
public class DeptConsumerDashboard_8080 {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumerDashboard_8080.class,args);
    }
}
