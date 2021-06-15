package com.itheima.mybatis.sqlsession.proxy;

import com.itheima.mybatis.cfg.Mapper;
import com.itheima.utils.Executor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;

/**
 * @program: day01_eesy_04mybatis_design
 * @description
 * @author: 晏宝辉
 * @create: 2021-04-16 21:53
 **/
public class MapperProxy implements InvocationHandler {
    //map的key是全限定类名加方法名
    private Map<String, Mapper> mappers;
    private Connection coon;

    public MapperProxy(Map<String,Mapper> mappers,Connection coon){
        this.mappers = mappers;
        this.coon = coon;
    }
    /**
     * 用于对方法进行增强,我们的增强其实是调用selectList方法
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //获取方法名
        String methodName =method.getName();
        //获取类名
        String className = method.getDeclaringClass().getName();
        //组合key
        String key = className+"."+methodName;
        //获取mappers中的mapper对象
        Mapper mapper = mappers.get(key);
        if (mapper==null){
            throw new IllegalArgumentException("传入参数有误");
        }
        //调用工具类查询所有
        return new Executor().selectList(mapper,coon);
    }
}
