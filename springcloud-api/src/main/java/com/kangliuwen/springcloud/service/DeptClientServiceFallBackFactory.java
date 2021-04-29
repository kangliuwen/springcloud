package com.kangliuwen.springcloud.service;

import com.kangliuwen.springcloud.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author klw
 * @Description(复杂调用逻辑时的描述):
 * @date 2021-02-26 21:30
 */
//降级
@Component
public class DeptClientServiceFallBackFactory implements FallbackFactory {
    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public Dept queryById(Long id) {
                return new Dept().setDeptId(id)
                        .setDeptName("id=>"+id+"没有对应的信息，客户端提供了降级的信息，这个服务以及被关闭")
                        .setDbName("没有数据");
            }

            @Override
            public List<Dept> queryAll() {
                return null;
            }

            @Override
            public Boolean addDept(Dept dept) {
                return null;
            }
        };
    }
}
