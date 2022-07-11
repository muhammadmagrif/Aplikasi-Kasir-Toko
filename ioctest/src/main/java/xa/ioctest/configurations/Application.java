package xa.ioctest.configurations;

import java.util.Scanner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import xa.ioctest.classes.HelloWorld;

@Configuration
public class Application {
    @Bean
    public HelloWorld helloWorld() {
        HelloWorld helloWorld = new HelloWorld();
//        helloWorld.setMessage("Hello World!");
        Scanner scan = new Scanner(System.in);
        System.out.println("Masukkan Pesan : ");
        String input = scan.nextLine();
        helloWorld.setMessage(input);
        scan.close();
        return helloWorld;
    }
}
