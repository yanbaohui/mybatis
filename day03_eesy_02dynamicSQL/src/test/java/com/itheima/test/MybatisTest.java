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
import java.util.ArrayList;
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

    @Test
    public void testFindUserByCondition(){
        User user = new User();
        user.setUsername("last_insert");
        user.setSex("男");
        List<User> users = userDao.findUserByCondition(user);
        for (User u : users) {
            System.out.println(u);
        }
    }

    @Test
    public void testFindUserInIds(){
        QueryVo vo = new QueryVo();
        List<Integer> list = new ArrayList<>();
        list.add(42);
        list.add(43);
        list.add(45);
        vo.setIds(list);
        List<User> users = userDao.findUserInIds(vo);
        for (User user : users) {
            System.out.println(user);
        }
    }
}
