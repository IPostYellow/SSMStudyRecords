package com.hj.dao;

import com.github.pagehelper.PageHelper;
import com.hj.pojo.User;
import com.hj.utils.MybatisUtils;
import com.sun.javafx.collections.MappingChange;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Test
    public void getUserByLimit() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < 6; i = i + 2) { //每页两个数据，从0开始
            map.put("startIndex", i);
            map.put("pageSize", 2);
            List<User> userByLimit = mapper.getUserByLimit(map);
            for (User user : userByLimit) {
                System.out.print(user + " ");
            }
            System.out.println();
        }
        sqlSession.close();
    }

    @Test
    public void getUserByRowBounds() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //通过java代码方面实现分页
        for (int i = 0; i < 5; i = i + 2) {
            RowBounds rowBounds = new RowBounds(i, 2);
            List<Object> userlist = sqlSession.selectList("com.hj.dao.UserMapper.getUserByRowBounds", null, rowBounds);
            for (Object o : userlist) {
                System.out.print(o + " ");
            }
            System.out.println();
        }
        sqlSession.close();
    }

    @Test
    public void getUserByPageHelp() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //使用mapper接口方式调用
        for(int i=0;i<=5;i=i+2){
            PageHelper.startPage(i, 2);
            List<User> userList = mapper.getUserList();
            for (User user : userList) {
                System.out.print(user);
            }
            System.out.println();
        }
        sqlSession.close();
    }
}
