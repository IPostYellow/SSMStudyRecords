package com.hj.mapper;

import com.hj.pojo.User;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.List;

public class UserMapperImpl2 implements UserMapper {
    private SqlSessionTemplate sqlSessionTemplate;
    private final PlatformTransactionManager transactionManager;//事务
    public UserMapperImpl2(SqlSessionTemplate sqlSessionTemplate, PlatformTransactionManager transactionManager) {
        this.sqlSessionTemplate = sqlSessionTemplate;
        this.transactionManager = transactionManager;
    }

    public List<User> selectUser() {
        return sqlSessionTemplate.getMapper(UserMapper.class).selectUser();
    }

    public int addUser(User user) {
        return sqlSessionTemplate.getMapper(UserMapper.class).addUser(user);
    }

    public int deleteUser(int id) {
        return sqlSessionTemplate.getMapper(UserMapper.class).deleteUser(id);
    }

    public void transactionTest() throws Exception {
        TransactionStatus txStatus =
                transactionManager.getTransaction(new DefaultTransactionDefinition());
        UserMapper mapper = sqlSessionTemplate.getMapper(UserMapper.class);
        try {
            User user = new User(7, "李雷", "232216500");
            mapper.addUser(user);
            mapper.deleteUser(6);
        } catch (Exception e) {
            transactionManager.rollback(txStatus);
            throw e;
        }
        transactionManager.commit(txStatus);
    }
}
