package com.kangliuwen.springcloud.controller;

import com.kangliuwen.springcloud.pojo.Dept;
import com.kangliuwen.springcloud.service.DeptService;
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

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping("/dept/add")
    public boolean addDept(Dept dept){
        return deptService.addDept(dept);
    }
    @GetMapping("/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return deptService.queryById(id);
    }
    @GetMapping("/dept/list")
    public List<Dept> queryAll(Dept dept){
        return deptService.queryAll();
    }

    //获取一些注册的微服务信息
    @GetMapping("/dept/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        System.out.println("services=>"+services);
        List<ServiceInstance> instances = discoveryClient.getInstances("SPRINGCLOUD-PROVIDER-DEPT");
        for (ServiceInstance instance : instances) {
            System.out.println(instance.getHost()+instance.getPort()+instance.getUri());
        }
        return this.discoveryClient;
    }






}
