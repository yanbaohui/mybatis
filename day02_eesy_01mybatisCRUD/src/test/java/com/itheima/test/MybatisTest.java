package com.itheima.test;

import com.itheima.dao.IUserDao;
import com.itheima.domain.QueryVo;
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
 * @program: day02_eesy_01mybatisCRUD
 * @description
 * @author: 晏宝辉
 * @create: 2021-04-17 13:16
 **/
public class MybatisTest {
    private InputStream in;
    private SqlSession sqlSession;
    private IUserDao userDao;


    @Before
    public void init() throws Exception{
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        sqlSession = sqlSessionFactory.openSession();
        userDao = sqlSession.getMapper(IUserDao.class);
    }

    @After
    public void destroy() throws Exception{
        //提交事务
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }

    @Test
    public void testFindAll(){

        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }

    }

    @Test
    public void testSaveUser() {
        User user = new User("last_insert","成都市武侯区","男",new Date());
        System.out.println("保存操作之前" + user);
        userDao.saveUser(user);
        System.out.println("保存操作之后" + user);

    }

    @Test
    public void testUpdateUser(){
        User user = new User("晏宝辉","成都市","男",new Date());
        user.setId(55);
        userDao.updateUser(user);
    }

    @Test
    public void testDeleteUser(){
        userDao.deleteUser(55);
    }
    @Test
    public void testQueryUserById(){
        User user = userDao.queryUserById(53);
        System.out.println(user);
    }

    @Test
    public void testQueryByName(){
        List<User> users = userDao.queryByName("%my%");
//        List<User> users = userDao.queryByName("my");
        for (User user : users) {
            System.out.println(user);
        }
    }
    @Test
    public void testQueryTotal(){
        int total = userDao.queryTotal();
        System.out.println(total);
    }

    @Test
    public void testFindUserByVo(){
        QueryVo vo = new QueryVo();
        User user = new User();
        user.setUsername("%my%");
        vo.setUser(user);
        List<User> users = userDao.findUserByVo(vo);
        for (User user1 : users) {
            System.out.println(user1);
        }
    }
}
