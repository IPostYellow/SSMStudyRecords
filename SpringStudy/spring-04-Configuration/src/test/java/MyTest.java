import com.hj.pojo.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 依然可以取到beans.xml里注册的对象
        User newUser = (User) context.getBean("user");
        newUser.show();
        // 也可以取得beans2.xml里注册的对象
        User user2 = (User) context.getBean("from2User");
        user2.show();
    }
}
