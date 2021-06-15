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

import java.io.InputStream;
import java.util.List;

/**
 * @program: day02_eesy_01mybatisCRUD
 * @description
 * @author: 晏宝辉
 * @create: 2021-04-17 13:16
 **/
public class UserTest {
    private InputStream in;
    private SqlSession sqlSession;
    private IUserDao userDao;
    private SqlSessionFactory sqlSessionFactory;


    @Before
    public void init() throws Exception{
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
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

    /**
     * 测试一级缓存，一级缓存为sqlSession提供
     * 当sqlSession对象被销毁，或者调用修改，删除，添加，commit，close等方法一级缓存会被销毁
     */
    @Test
    public void testFirstLevelCache(){
        User user1 = userDao.queryUserById(56);
        System.out.println(user1);
        sqlSession.close();
        sqlSession = sqlSessionFactory.openSession();
        userDao = sqlSession.getMapper(IUserDao.class);
        User user2 = userDao.queryUserById(56);
        System.out.println(user2);
        System.out.println(user1==user2);
    }

    /**
     * 测试缓存同步
     */
    @Test
    public void testClearCache(){
        User user1 = userDao.queryUserById(56);
        System.out.println(user1);

        user1.setUsername("update clear cache");
        user1.setAddress("北京市");
        userDao.updateUser(user1);

        User user2 = userDao.queryUserById(56);
        System.out.println(user2);
        System.out.println(user1==user2);
    }

}
