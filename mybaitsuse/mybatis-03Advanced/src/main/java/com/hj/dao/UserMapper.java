package com.hj.dao;

import com.hj.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    //查询全部用户
    List<User> getUserList();

    //根据ID查询用户
    User getUserById(int id);

    //使用map根据ID查询用户
    User getUserByIdUseMap(Map<String,Object> map);

    //insert一个用户
    boolean insertUser(User user);

    //使用map来增加用户
    boolean insertUserUseMap(Map<String, Object> map);

    //修改用户
    boolean updateUser(User user);

    //删除用户
    boolean deleteUser(int id);

    //模糊查询
    List<User> getUserLike(String value);
}
