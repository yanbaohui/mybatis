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
    User queryUserById(Integer userId);
    List<User> queryByName(String username);
    /**
     * 根据QueryVo中的条件查询用户
     * @param vo
     * @return
     */
    List<User> findUserByVo(QueryVo vo);

    /**
     * 根据传入的参数条件查询
     * @param user 查询的条件，有可能是用户名，有可能是性别，也有可能是地址，还有可能都没有
     * @return
     */
    List<User> findUserByCondition(User user);

    List<User> findUserInIds(QueryVo vo);
}
