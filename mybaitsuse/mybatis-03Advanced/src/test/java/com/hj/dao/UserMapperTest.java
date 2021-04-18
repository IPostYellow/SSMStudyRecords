package com.hj.dao;

import com.hj.pojo.User;
import com.hj.utils.MybatisUtils;
import jdk.internal.org.objectweb.asm.tree.analysis.Value;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
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
            //方法二：不推荐这种方法
            List<User> objectList = sqlSession.selectList("com.hj.dao.UserMapper.getUserList");
            for (User o : objectList) {
                System.out.println(o);
            }
        } finally {
            //关闭sqlSession
            sqlSession.close();
        }
    }
    @Test
    public void getUserLike(){
        SqlSession sqlSession=MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> userList =mapper.getUserLike("李");

        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();
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
    public void getUserByIdUseMap() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("id", 3);
        map.put("name", "王五");
        User user =mapper.getUserByIdUseMap(map);
        System.out.println(user);
        sqlSession.close();
    }

    //增删改要提交事务
    @Test
    public void insertUser() {
        SqlSession sqlSession;
        //获得SqlSession对象
        sqlSession = MybatisUtils.getSqlSession();
        //获取mapper对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User addUser = new User(5, "吴六", "666");
        //那些实现的接口都在mapper对象里调用
        boolean flag = mapper.insertUser(addUser);
        System.out.println(flag);
        if (flag) System.out.println("插入成功");
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void insertUserUseMap() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("userId", 5); //这里的键名要和mapper.xml里一致
        map.put("userName", "李飞");
        map.put("password", "485615");
        boolean flag = mapper.insertUserUseMap(map);
        if (flag) System.out.println("插入成功");
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(4, "赵七", "77777");
        boolean flag = mapper.updateUser(user);
        if (flag) {
            System.out.println("修改成功");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUser(5);
        sqlSession.commit();
        sqlSession.close();
    }
}
