package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pojo.User;

@Configuration
public class MyConfig {

    @Bean
    public User getUser(){
        return new User();
    }
}
