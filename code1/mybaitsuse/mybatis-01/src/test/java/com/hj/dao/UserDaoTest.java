package com.hj.dao;
import org.apache.ibatis.session.SqlSessionFactory;
import com.hj.pojo.User;
import com.hj.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {
    @Test
    public void test() {
        SqlSession sqlSession;
        //获得SqlSession对象
        sqlSession = MybatisUtils.getSqlSession();
        try {
            //方法一：利用getMapper，执行SQL
            UserDao userDao = sqlSession.getMapper(UserDao.class); //获取对应的接口的对象
            List<User> userList = userDao.getUserList();
            for (User user : userList) {
                System.out.println(user);
            }
            //方法二：不推荐这种方法
            List<User> objectList = sqlSession.selectList("com.hj.dao.UserDao.getUserList");
            for (User o : objectList) {
                System.out.println(o);
            }
        } finally {
            //关闭sqlSession
            sqlSession.close();
        }
    }
}
