package com.kangliuwen.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author klw
 * @Description(复杂调用逻辑时的描述):
 * @date 2021-02-25 10:53
 */
@SpringBootApplication
@EnableEurekaServer //服务端启动类，访问http://localhost:7001/
public class EurekaServer_7003 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer_7003.class,args);
    }
}
