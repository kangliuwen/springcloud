package com.kangliuwen.springcloud.service;

import com.kangliuwen.springcloud.pojo.Dept;

import java.util.List;

/**
 * @author klw
 * @Description(复杂调用逻辑时的描述):
 * @date 2021-02-23 17:26
 */
public interface DeptService {
    public boolean addDept(Dept dept);
    public Dept queryById(Long id);
    public List<Dept> queryAll();
}
