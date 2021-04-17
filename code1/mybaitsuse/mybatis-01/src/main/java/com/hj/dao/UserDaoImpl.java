package com.hj.dao;

import com.hj.pojo.User;

import java.util.List;
//本来这边是需要使用JDBC代码去实现接口的，但是mybatis可以使用xml代替这一情况
public class UserDaoImpl implements UserDao{
    public List<User> getUserList() {
        return null;
    }
}
