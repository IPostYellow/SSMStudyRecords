package com.hj.mapper;

import com.hj.pojo.User;

import java.util.List;

public interface UserMapper {
    // 查询所有用户
    public List<User> selectUser();

    // 添加一个用户
    public int addUser(User user);

    // 删除一个用户
    public int deleteUser(int id);

    public void transactionTest() throws Exception;
}
