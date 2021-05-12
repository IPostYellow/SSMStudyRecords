import com.hj.pojo.Hello;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        //获取spring的上下文对象
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        //我们的对象现在都在spring中管理了，我们要使用，直接去取出来就可以了
        Hello hello = (Hello) context.getBean("hello");
        System.out.println(hello.toString());//Hello{str='Spring'}
        //思考？
        //Hello对象是谁创建的？是由Spring创建的
        //Hello对象的属性是怎么设置的？是由Spring容器设置的
    }
}
