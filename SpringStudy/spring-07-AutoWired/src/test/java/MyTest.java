import com.hj.pojo.Person;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Person person = context.getBean("person", Person.class);
        person.getCat().shout();
        person.getDog().shout();

        Person person2 = context.getBean("person2", Person.class);
        person2.getDog().shout();
        person2.getCat().shout();
    }
}
