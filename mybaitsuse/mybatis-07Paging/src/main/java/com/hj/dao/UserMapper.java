package com.hj.dao;

import com.hj.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    //查询全部用户
    List<User> getUserList();

    //根据ID查询用户
    User getUserById(int id);

    //分页
    List<User> getUserByLimit(Map<String, Integer> map);

    //分页2
    List<User> getUserByRowBounds();

}
