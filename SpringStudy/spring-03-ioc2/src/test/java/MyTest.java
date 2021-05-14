import com.hj.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        //获取spring的上下文对象
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        //我们的对象现在都在spring中管理了，我们要使用，直接去取出来就可以了
        //这个时候就已经走了无参构造方法了，说明对象已经被创建了
        //说明对象在context的时候就已经被创建了
        User bean = (User)context.getBean("user");
        bean.show();
        User bean2 = (User)context.getBean("user2");
        bean2.show();
        User bean3 = (User)context.getBean("user3");
        bean2.show();
        //User有参构造
        //User有参构造
        //User有参构造
        //name=Spring
        //name=Spring
        //name=Spring
    }
}
