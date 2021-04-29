package com.kangliuwen.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author klw
 * @Description(复杂调用逻辑时的描述):
 * @date 2021-02-24 16:56
 */
@Configuration
public class ConfigBean {

    //IRule
    //RoundBobinRule 轮询，默认
    //RandomRule 随机
    //AvailabilityFilteringRule,会先过滤掉，跳闸的故障服务，对剩下的进行轮询
    //RetryRule 会先按照轮询获取服务，如果服务获取失败，则会在指定的时间内进行重试

    @Bean
    @LoadBalanced //配置负载均衡实现RestTemplate
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @Bean
    public IRule myRule(){
        return new RandomRule();//指定随机规则作为负载均衡
    }
}
