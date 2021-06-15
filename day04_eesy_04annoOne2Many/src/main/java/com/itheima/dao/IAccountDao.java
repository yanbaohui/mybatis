package com.itheima.dao;

import com.itheima.domain.Account;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @program: day04_eesy_04annoOne2Many
 * @description
 * @author: 晏宝辉
 * @create: 2021-04-19 21:36
 **/
public interface IAccountDao {

    /**
     * 查询所有账户，并且获取每个账户所属的用户信息
     * @return
     */
    @Select("select * from account")
    @Results(id = "accountMap" , value = {
            @Result(id = true,column = "id" ,property = "id"),
            @Result(column = "uid" , property = "uid"),
            @Result(column = "money" , property = "money"),
            @Result(property = "user" , column = "uid" , one = @One(select="com.itheima.dao.IUserDao.findUserById",fetchType= FetchType.EAGER))
    })
    List<Account> findAll();

    /**
     * 根据用户id查询账户信息
     * @param userId
     * @return
     */
    @Select("select * from account where uid = #{userId}")
    @ResultMap("accountMap")
    List<Account> findAccountByUid(Integer userId);
}
