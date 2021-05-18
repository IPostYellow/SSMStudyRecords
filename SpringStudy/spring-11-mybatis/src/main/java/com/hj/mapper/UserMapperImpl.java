package com.hj.mapper;

import com.hj.pojo.User;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

public class UserMapperImpl implements UserMapper {
    //我们所有的操作，在mybatis的时候都使用sqlSession来执行，现在都使用SqlSessionTemplate执行
    private SqlSessionTemplate sqlSession;

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    public List<User> selectUser() {
        return sqlSession.getMapper(UserMapper.class).selectUser();
    }
}
