import com.demo.Spring_V6.DeptService;
import com.demo.Spring_V6.JavaConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Aurora
 * @date 2025年12月30日 22:35
 */
public class Spring_V6_Test {
    @Test
    public void test(){
        ApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(JavaConfig.class);
        DeptService bean = annotationConfigApplicationContext.getBean(DeptService.class);
        System.out.println( bean);
    }
}
