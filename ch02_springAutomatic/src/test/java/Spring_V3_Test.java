import com.demo.Spring_V3.JavaConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

/**
 * @author Aurora
 * @date 2025年12月30日 22:35
 */
public class Spring_V3_Test {
    @Test
    public void test(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(JavaConfig.class);
        System.out.println(annotationConfigApplicationContext.getBean("userService"));
    }
}
