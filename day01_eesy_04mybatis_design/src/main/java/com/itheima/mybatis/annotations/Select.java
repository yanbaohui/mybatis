package com.itheima.mybatis.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @program: day01_eesy_04mybatis_design
 * @description
 * @author: 晏宝辉
 * @create: 2021-04-17 12:12
 * 查询的注解
 **/

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Select {
    /**
     * 配置sql语句的
     * @return
     */
    String value();
}
