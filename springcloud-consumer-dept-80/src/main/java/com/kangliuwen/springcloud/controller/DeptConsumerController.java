package com.kangliuwen.springcloud.controller;

import com.kangliuwen.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author klw
 * @Description(复杂调用逻辑时的描述):
 * @date 2021-02-24 9:17
 */
@RestController
public class DeptConsumerController {

    @Autowired
    private RestTemplate restTemplate;//提供多种便捷远程访问http服务的方法，简单的RestFull服务模板

    //private static final String REST_URL_PREFIX = "http://localhost:8081";
    //使用Ribbon后这里的地址应该是一个变量，通过服务名来访问，Ribbon和Eureka整合后，客户端掉用服务端不用关心服务端ip地址和端口号
    private static final String REST_URL_PREFIX = "http://SPRINGCLOUD-PROVIDER-DEPT";

    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){

        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id,Dept.class);
    }
    @RequestMapping("/consumer/dept/add")
    public  boolean add(Dept dept){
        return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add",dept,Boolean.class);
    }
    @RequestMapping("/consumer/dept/list")
    public List<Dept> list(){

        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list",List.class);
    }



















}
