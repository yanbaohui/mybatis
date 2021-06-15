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

/**
 * @program: day02_eesy_01mybatisCRUD
 * @description
 * @author: 晏宝辉
 * @create: 2021-04-17 13:16
 **/
public class SecondLevelCacheTest {
    private InputStream in;
    private SqlSessionFactory sqlSessionFactory;



    @Before
    public void init() throws Exception{
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);

    }

    @After
    public void destroy() throws Exception{

        in.close();
    }

    /**
     * 测试二级缓存，二级缓存由sqlSessionFactory提供
     * 并且sqlSessionFactory创建的的哟个sqlSession对象共享缓存
     *
     */
    @Test
    public void testFirstLevelCache(){
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        IUserDao dao1 = sqlSession1.getMapper(IUserDao.class);
        User user1 = dao1.queryUserById(56);
        System.out.println(user1);
        sqlSession1.close();//一级缓存消失

        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        IUserDao dao2 = sqlSession2.getMapper(IUserDao.class);
        User user2 = dao2.queryUserById(56);
        System.out.println(user2);
        sqlSession2.close();

        //结果为false 因为二级缓存 sqlSessionFactory里面存的是数据而不是对象
        System.out.println(user1==user2);
    }



}
