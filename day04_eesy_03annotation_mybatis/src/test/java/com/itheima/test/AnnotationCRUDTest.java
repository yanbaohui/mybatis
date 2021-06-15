package com.itheima.test;

import com.itheima.dao.IUserDao;
import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @program: day04_eesy_03annotation_mybatis
 * @description
 * @author: 晏宝辉
 * @create: 2021-04-19 17:39
 **/
public class AnnotationCRUDTest  {
    private SqlSessionFactory factory;
    private SqlSession sqlSession;
    private IUserDao userDao;
    private InputStream in;

    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        sqlSession = factory.openSession(true);
        userDao = sqlSession.getMapper(IUserDao.class);
    }

    @After
    public void destroy() throws IOException {
        sqlSession.close();
        in.close();
    }

    @Test
    public void testSaveUser(){
        User user = new User();
        user.setUsername("mybatis annotation");
        user.setAddress("北京市天安门");
        user.setSex("男");
        user.setBirthday(new Date());

        userDao.saveUser(user);

    }

    @Test
    public void testUpdateUser(){
        User user = new User();
        user.setId(58);
        user.setUsername("mybatis annotation update");
        user.setAddress("北京市天安门");
        user.setSex("男");
        user.setBirthday(new Date());
        userDao.updateUser(user);
    }

    @Test
    public void testDelete(){
        userDao.deleteUser(58);
    }

    @Test
    public void testFindUserById(){
        User user = userDao.findUserById(56);
        System.out.println(user);
    }

    @Test
    public void testFindUserByName(){
        List<User> users = userDao.findUserByName("%mybatis%");
        for (User user : users) {
            System.out.println(user);
        }
    }

}
