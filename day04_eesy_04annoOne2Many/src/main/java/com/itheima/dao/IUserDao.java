package com.itheima.dao;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;


import java.util.List;

/**
 * @program: day04_eesy_03annotation_mybatis
 * @description
 * @author: 晏宝辉
 * @create: 2021-04-19 16:02
 **/
@CacheNamespace(blocking = true)
public interface IUserDao {
    /**
     * 查询所有用户
     * @return
     */

    @Select("select * from user")
    @Results( id = "userMap",value = {
            @Result(id = true, column = "id" , property = "userId"),
            @Result( column = "username" , property = "userName"),
            @Result( column = "address" , property = "userAddress"),
            @Result( column = "sex" , property = "userSex"),
            @Result( column = "birthday" , property = "userBirthday"),
            @Result(property = "accounts" ,column = "id" , many = @Many(select = "com.itheima.dao.IAccountDao.findAccountByUid",fetchType = FetchType.LAZY))
    })

    List<User> findAll();

    /**
     * 根据ID查询用户
     * @return
     */
    @Select("select * from user where id = #{id}")
    @ResultMap(value = {"userMap"})
    User findUserById(Integer userId);

    /**
     * 根据用户模糊查询
     * @param username
     * @return
     */
    @Select("select * from user where username like #{username}")
    @ResultMap(value = {"userMap"})
    List<User> findUserByName(String username);



}
