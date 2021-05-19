import com.hj.mapper.UserMapper;
import com.hj.mapper.UserMapperImpl;
import com.hj.pojo.User;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MyTest {
    @Test
    public void test(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationcontext.xml");
        UserMapper userMapperImpl = context.getBean("userMapperImpl", UserMapper.class);
        List<User> userList = userMapperImpl.selectUser();
        for (User user : userList) {
            System.out.println(user);
        }
    }
    @Test
    public void test2() throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationcontext.xml");
        UserMapper userMapperImpl = context.getBean("userMapperImpl", UserMapper.class);
        userMapperImpl.transactionTest();
    }
    @Test
    public void test3() throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationcontext.xml");
        UserMapper userMapperImpl2 = context.getBean("userMapperImpl2", UserMapper.class);
        userMapperImpl2.transactionTest();
    }
}
