package com.kangliuwen.springcloud.controller;

import com.kangliuwen.springcloud.pojo.Dept;
import com.kangliuwen.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author klw
 * @Description(复杂调用逻辑时的描述):
 * @date 2021-02-24 9:17
 */
@RestController
public class DeptConsumerController {

   /* @Autowired
    private RestTemplate restTemplate;//提供多种便捷远程访问http服务的方法，简单的RestFull服务模板
*/
    //private static final String REST_URL_PREFIX = "http://localhost:8081";
    //使用Ribbon后这里的地址应该是一个变量，通过服务名来访问，Ribbon和Eureka整合后，客户端掉用服务端不用关心服务端ip地址和端口号
    //private static final String REST_URL_PREFIX = "http://SPRINGCLOUD-PROVIDER-DEPT:8081";
    //使用feign后
    @Autowired
    private DeptClientService deptClientService = null;

    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){

        return deptClientService.queryById(id);
    }
    @RequestMapping("/consumer/dept/add")
    public  boolean add(Dept dept){
        return deptClientService.addDept(dept);
    }
    @RequestMapping("/consumer/dept/list")
    public List<Dept> list(){
        return deptClientService.queryAll();
    }



















}
