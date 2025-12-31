import com.demo.Spring_V3.UserService;
import com.demo.Spring_V6.DeptService;
import com.demo.Spring_V6.JavaConfig;
import com.demo.Spring_V7.Demo3JavaConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Aurora
 * @date 2025年12月30日 22:35
 */
public class Spring_V7_Test {
    @Test
    public void test(){
        ApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(Demo3JavaConfig.class);
        UserService bean = annotationConfigApplicationContext.getBean(UserService.class);
        System.out.println( bean);
    }
}
