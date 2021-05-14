import com.hj.pojo.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("UserBean.xml");
        User user = context.getBean("user", User.class);
        System.out.println(user.toString());//User{name='张三', age=18}
        User user2 =context.getBean("user2",User.class);
        System.out.println(user2.toString());//User{name='李四', age=21}
    }
}
