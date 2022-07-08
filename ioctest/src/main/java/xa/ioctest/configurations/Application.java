package xa.ioctest.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import xa.ioctest.classes.HelloWorld;

@Configuration
public class Application {
    @Bean
    public HelloWorld helloWorld() {
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.setMessage("Hello World!");
        return helloWorld;
    }
}
