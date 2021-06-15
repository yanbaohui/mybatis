package com.itheima.dao;


import com.itheima.domain.Account;
import com.itheima.domain.User;

import java.util.List;

/**
 * @program: day02_eesy_01mybatisCRUD
 * @description
 * @author: 晏宝辉
 * @create: 2021-04-17 13:12
 **/
public interface IUserDao {
    /**
     * 查询所有用户，同时获取所有账户的信息
     * @return
     */
    List<User> findAll();
    User queryUserById(Integer userId);

    /**
     * 根据用户id查询账户信息
     * @param userId
     * @return
     */
    List<Account> findAccountByUid(Integer userId);

}
