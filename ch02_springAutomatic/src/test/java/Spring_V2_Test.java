import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Aurora
 * @date 2025年12月30日 22:35
 */
public class Spring_V2_Test {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring_v2.xml");
        System.out.println(context.getBean("userService"));
    }
}
