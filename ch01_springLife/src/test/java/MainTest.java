import com.demo.bean.Dog;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Aurora
 * @date 2025年12月30日 21:12
 */
public class MainTest {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        context.getBean(Dog.class);
        System.out.println("8.Bean的使用");
        ((ClassPathXmlApplicationContext)context).close();
    }

}
