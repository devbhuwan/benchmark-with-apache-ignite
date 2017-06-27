package horizontal.scaling.benchmark;

import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Bhuwan Upadhyay
 * @date 2017/06/27
 */
@Configuration
public class IgniteClientNodeApplication {

    @Bean
    public static Ignite igniteInstance() {
        Ignition.setClientMode(true);
        return Ignition.start("ignite-client-node.xml");
    }

}
