package com.itheima.dao;

import com.itheima.domain.Role;

import java.util.List;

/**
 * @program: day03_eesy_04many2many
 * @description
 * @author: 晏宝辉
 * @create: 2021-04-18 15:18
 **/
public interface IRoleDao {
    /**
     * 查询所有角色
     * @return
     */
    List<Role> findAll();
}
