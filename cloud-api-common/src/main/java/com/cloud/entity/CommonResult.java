package com.cloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author chuke
 * @create 2020/8/4 18:29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String msg;
    private T     data;
    public CommonResult(Integer code,String msg){
        this(code,msg,null);
    }
}
