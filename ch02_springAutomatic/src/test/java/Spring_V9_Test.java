import com.demo.Spring_V9.MessageService;
import com.demo.Spring_V9.MessageServiceConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Aurora
 * @date 2025年12月30日 22:35
 */
public class Spring_V9_Test {
    @Test
    public void test(){

        ApplicationContext context = new AnnotationConfigApplicationContext(MessageServiceConfig.class);
        MessageService helloMessageService = context.getBean("helloMessageService", MessageService.class);
        MessageService hiMessageService = context.getBean("hiMessageService", MessageService.class);

        System.out.println(helloMessageService.getMessage());
        System.out.println(hiMessageService.getMessage());
    }
}
