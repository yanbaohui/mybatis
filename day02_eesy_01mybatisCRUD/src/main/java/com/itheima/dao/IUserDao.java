package com.itheima.dao;

import com.itheima.domain.QueryVo;
import com.itheima.domain.User;

import java.util.List;

/**
 * @program: day02_eesy_01mybatisCRUD
 * @description
 * @author: 晏宝辉
 * @create: 2021-04-17 13:12
 **/
public interface IUserDao {
    List<User> findAll();
    void saveUser(User user);
    void updateUser(User user);
    void deleteUser(Integer userId);
    User queryUserById(Integer userId);
    List<User> queryByName(String username);
    int queryTotal();

    /**
     * 根据QueryVo中的条件查询用户
     * @param vo
     * @return
     */
    List<User> findUserByVo(QueryVo vo);
}
