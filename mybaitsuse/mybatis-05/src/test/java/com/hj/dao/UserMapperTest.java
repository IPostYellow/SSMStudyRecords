package com.hj.dao;

import com.hj.pojo.User;
import com.hj.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {
    @Test
    public void test() {
        SqlSession sqlSession;
        //获得SqlSession对象
        sqlSession = MybatisUtils.getSqlSession();
        try {
            //方法一：利用getMapper，执行SQL
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class); //获取对应的接口的对象
            List<User> userList = userMapper.getUserList();
            for (User user : userList) {
                System.out.println(user);
            }
        } finally {
            //关闭sqlSession
            sqlSession.close();
        }
    }
    @Test
    public void getUserById() {
        SqlSession sqlSession;
        //获得SqlSession对象
        sqlSession = MybatisUtils.getSqlSession();
        //获取mapper对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //那些实现的接口都在mapper对象里调用
        User userById = mapper.getUserById(5);
        System.out.println(userById);

        sqlSession.close();
    }
}
