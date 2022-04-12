package boot.example.myappspringbootautoconfigure;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author 沈永康
 * @Date 2022/3/8 20:03
 * @Version 1.0
 */

@ConditionalOnWebApplication

@EnableConfigurationProperties(HelloProperties.class)

@Configuration
public class HelloServiceAutoConfiguration {
    @Autowired
    private HelloProperties helloProperties;
    @Bean
    public HelloService helloService(){
        HelloService helloService =new HelloService();
        helloService.setHelloProperties(helloProperties);
        return  helloService;
    }
}
