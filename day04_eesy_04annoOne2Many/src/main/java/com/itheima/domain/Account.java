package com.itheima.domain;

import java.io.Serializable;

/**
 * @program: day04_eesy_04annoOne2Many
 * @description
 * @author: 晏宝辉
 * @create: 2021-04-19 21:35
 **/
public class Account implements Serializable {
    private Integer id;
    private Integer uid;
    private Double money;

    //多对一，mybatis称之为一对一的关系映射，一个账户只能属于一个用户
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", uid=" + uid +
                ", money=" + money +
                '}';
    }
}
