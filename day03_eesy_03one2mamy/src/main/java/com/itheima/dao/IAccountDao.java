package com.itheima.dao;

import com.itheima.domain.Account;

import java.util.List;

/**
 * @program: day03_eesy_03one2mamy
 * @description
 * @author: 晏宝辉
 * @create: 2021-04-18 13:55
 **/
public interface IAccountDao {
    /**
     * 查询所有账户，同时还要获取到当前账户的所有信息
     * @return
     */
    List<Account> findAll();

    /**
     * 查询所有账户，并且带有用户名称和地址信息
     * @return
     */
}
