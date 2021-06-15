package com.itheima.dao;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @program: day04_eesy_03annotation_mybatis
 * @description
 * @author: 晏宝辉
 * @create: 2021-04-19 16:02
 **/
public interface IUserDao {
    /**
     * 查询所有用户
     * @return
     */

    @Select("select * from user")
    List<User> findAll();

    /**
     *保存用户
     */
    @Insert("insert into user(username,address,sex,birthday)values(#{username},#{address},#{sex},#{birthday})")
    void saveUser(User user);

    /**
     * 更新用户
     */
    @Update("update user set username=#{username},address=#{address},sex=#{sex},birthday=#{birthday} where id=#{id}")
    void updateUser(User user);

    /**
     * 删除用户
     * @param userId
     */
    @Delete("delete from user where id=#{id}")
    void deleteUser(Integer userId);

    /**
     * 根据ID查询用户
     * @return
     */
    @Select("select * from user where id = #{id}")
    User findUserById(Integer userId);

    /**
     * 根据用户模糊查询
     * @param username
     * @return
     */
    @Select("select * from user where username like #{username}")
    List<User> findUserByName(String username);

}
