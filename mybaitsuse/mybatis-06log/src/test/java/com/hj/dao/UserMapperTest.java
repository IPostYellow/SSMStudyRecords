package com.hj.dao;

import com.hj.pojo.User;
import com.hj.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {
    static Logger logger = Logger.getLogger(UserMapperTest.class);
    @Test
    public void test() {
        SqlSession sqlSession;
        //获得SqlSession对象
        sqlSession = MybatisUtils.getSqlSession();
        logger.info("进入test方法成功！");
        logger.info("现在看看sqlSession对象有没有问题 "+sqlSession);//加入自己的debug信息，代替了System.out.println(sqlSession)
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

    @Test
    public void testLog4j() {
        logger.info("info：进入了testLog4j");
        logger.debug("debug：进入了testLog4j调试");
        logger.error("error：进入了testLog4j");
    }
}
