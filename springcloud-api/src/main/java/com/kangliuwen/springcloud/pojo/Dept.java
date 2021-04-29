package com.kangliuwen.springcloud.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author klw
 * @Description(复杂调用逻辑时的描述):
 * @date 2021-02-23 16:30
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)//链式写法，dept.setDeptId(11).setdeptName('sss').setDbName('001')

public class Dept implements Serializable {
    private Long deptId;
    private String deptName;
    private String dbName;

    public Dept(String dbName) {
        this.dbName = dbName;
    }
}
