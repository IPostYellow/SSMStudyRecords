import com.hj.pojo.Student;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student st = (Student) context.getBean("student");
        System.out.println(st.toString());
    }
}
