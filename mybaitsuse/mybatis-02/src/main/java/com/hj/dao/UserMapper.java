package com.hj.dao;

import com.hj.pojo.User;

import java.util.List;

public interface UserMapper {
    //查询全部用户
    List<User> getUserList();

    //根据ID查询用户
    User getUserById(int id);

    //insert一个用户
    boolean insertUser(User user);

    //修改用户
    boolean updateUser(User user);

    //删除用户
    boolean deleteUser(int id);
}
