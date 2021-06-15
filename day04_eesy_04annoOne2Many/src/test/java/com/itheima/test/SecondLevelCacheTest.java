package com.itheima.test;

import com.itheima.dao.IAccountDao;
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

/**
 * @program: day04_eesy_04annoOne2Many
 * @description
 * @author: 晏宝辉
 * @create: 2021-04-19 22:04
 * 测试mybatis的二级缓存，也就是SqlSessionFactory的缓存机制
 * 一级缓存SqlSession的缓存mybatis默认开启
 **/
public class SecondLevelCacheTest {
    private SqlSessionFactory factory;
    private SqlSession sqlSession;
    private IUserDao userDao;
    private InputStream in;

    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        sqlSession = factory.openSession();
        userDao = sqlSession.getMapper(IUserDao.class);
    }

    @After
    public void destroy() throws IOException {

        in.close();
    }

    @Test
    public void testFindUserById() {
        User user = userDao.findUserById(56);
        System.out.println(user);
        sqlSession.close();//释放一级缓存

        SqlSession session = factory.openSession();//再次打开session
        IUserDao userDao1 = session.getMapper(IUserDao.class);

        User user1 = userDao1.findUserById(56);
        System.out.println(user == user1);


    }
}
