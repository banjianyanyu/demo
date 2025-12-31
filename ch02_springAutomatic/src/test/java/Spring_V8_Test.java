import com.demo.Spring_V3.UserService;
import com.demo.Spring_V7.Demo3JavaConfig;
import com.demo.Spring_V8.SearchService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ServiceLoader;

/**
 * @author Aurora
 * @date 2025年12月30日 22:35
 */
public class Spring_V8_Test {
    @Test
    public void test(){
        ServiceLoader<SearchService> loader = ServiceLoader.load(SearchService.class);
        for (SearchService service : loader) {
            System.out.println("  " + service.getClass().getSimpleName() + " - " + service);
            service.search("hello world");
        }
    }
}
