package com.hj.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
//@Component 等价于<bean id="user" class="com.hj.pojo.User">
@Component
public class User {
    @Value("张三")
    public String name;
}
