package com.itheima.mybatis.sqlsession;

/**
 * @program: day01_eesy_04mybatis_design
 * @description
 * @author: 晏宝辉
 * @create: 2021-04-16 21:11
 **/
public interface SqlSession {


    /**
     * 根据参数创建一个代理对象
     * @param daoInterfaceClass dao的接口字节码
     * @param <T>
     * @return
     */
    <T> T getMapper(Class<T> daoInterfaceClass);

    /**
     * 释放资源
     */
    void close();
}
