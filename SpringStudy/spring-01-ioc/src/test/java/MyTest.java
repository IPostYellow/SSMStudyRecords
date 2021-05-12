import com.hj.dao.UserDaoImpl;
import com.hj.dao.UserDaoOracleImpl;
import com.hj.service.UserService;
import com.hj.service.UserServiceImpl;

public class MyTest {
    public static void main(String[] args) {
//        //用户实际调用的是业务层，不需要接触dao层
//        UserServiceImpl userService =new UserServiceImpl();
//        userService.getUser();
        // 利用set注入的方法，我们可以不需要修改service中的代码，从而实现多个不同对象的getUser方法
        UserServiceImpl userService = new UserServiceImpl();
        userService.setUserDao(new UserDaoImpl());
        userService.getUser();//mysql实现
        userService.setUserDao(new UserDaoOracleImpl());
        userService.getUser();//oracle实现
    }
}
