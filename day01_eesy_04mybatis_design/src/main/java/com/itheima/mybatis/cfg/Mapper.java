package com.itheima.mybatis.cfg;

/**
 * @program: day01_eesy_04mybatis_design
 * @description
 * @author: 晏宝辉
 * @create: 2021-04-16 21:23
 * 用于封装执行的sql语句和结果类型的全限定类名
 **/
public class Mapper {
    private String queryString;//SQL
    private String resultType;//实体类全限定类名

    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }
}
