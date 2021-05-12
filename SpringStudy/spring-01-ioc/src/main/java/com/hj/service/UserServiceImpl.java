package com.hj.service;

import com.hj.dao.UserDao;
import com.hj.dao.UserDaoImpl;
import com.hj.dao.UserDaoOracleImpl;

public class UserServiceImpl implements UserService {
    //传统的方法中，如果这边要改变，那就必须将这里的语句改变才可以
//    private UserDao userDao = new UserDaoImpl();
    private UserDao userDao;
    // 利用set进行动态实现值的注入
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void getUser() {
        userDao.getUser();
    }
}
