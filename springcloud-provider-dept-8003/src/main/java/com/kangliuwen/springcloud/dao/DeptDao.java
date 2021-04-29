package com.kangliuwen.springcloud.dao;

import com.kangliuwen.springcloud.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author klw
 * @Description(复杂调用逻辑时的描述):
 * @date 2021-02-23 17:15
 */
@Mapper
@Repository
public interface DeptDao {
    public boolean addDept(Dept dept);
    public Dept queryById(Long id);
    public List<Dept> queryAll();
}
