import com.demo.Spring_V10.MessageService;
import com.demo.Spring_V9.MessageServiceConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.support.SpringFactoriesLoader;

import java.util.List;

/**
 * @author Aurora
 * @date 2025年12月30日 22:35
 */
public class Spring_V10_Test {
    @Test
    public void test(){

        List<MessageService> services = SpringFactoriesLoader.loadFactories(MessageService.class, null);
        for (MessageService service : services) {

            System.out.println(service.getMessage());
        }
    }
}
