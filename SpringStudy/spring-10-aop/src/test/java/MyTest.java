import com.hj.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 动态代理代理的是接口,getbean获取的是动态代理对象，所以这个对象的类型并不是实现类的类型，而是接口类型。所以这里直接UserService而不是UserServiceImpl
        UserService userService = context.getBean("userService", UserService.class);
        userService.add();
        userService.delete();

    }
}
