package boot.example.myappspringbootautoconfigure;


import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author 沈永康
 * @Date 2022/3/8 19:52
 * @Version 1.0
 */

@ConfigurationProperties(prefix = "myapp.hello")
public class HelloProperties {
    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    private String suffix;
    public  String getSuffix(){
        return suffix;
    }

}
