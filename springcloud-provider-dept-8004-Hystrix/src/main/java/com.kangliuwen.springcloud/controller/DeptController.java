package com.kangliuwen.springcloud.controller;

import com.kangliuwen.springcloud.pojo.Dept;
import com.kangliuwen.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**

 * @author klw
 * @Description(复杂调用逻辑时的描述):
 * @date 2021-02-23 17:28
 */
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @HystrixCommand(fallbackMethod = "gehystrixGett")
    @GetMapping("/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        Dept dept = deptService.queryById(id);
        if(dept==null){
            throw  new RuntimeException("Id=>"+id+",用户不存在，或者信息无法找到");
        }
        return dept;
    }

    public Dept gehystrixGett(@PathVariable("id") Long id){
        return new Dept().setDeptId(id).setDbName("no this database in MySQL").setDeptName("Id=>"+id+",用户不存在，或者信息无法找到");
    }






}
