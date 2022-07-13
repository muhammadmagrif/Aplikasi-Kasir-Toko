package xa.ioctest.configurations;

import java.util.Scanner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import xa.ioctest.classes.HelloWorld;
import xa.ioctest.classes.Palindrome;

@Configuration
public class Application {
    @Bean
//    public HelloWorld helloWorld() {
//        HelloWorld helloWorld = new HelloWorld();
////        helloWorld.setMessage("Hello World!");
//        Scanner scan = new Scanner(System.in);
//        System.out.println("Masukkan Pesan : ");
//        String input = scan.nextLine();
//        helloWorld.setMessage(input);
//        scan.close();
//        return helloWorld;
//    }
    
    public Palindrome palindrome() {
    	Palindrome palindrome = new Palindrome();
    	Scanner scan = new Scanner(System.in);
    	System.out.print("Masukkan Kalimat atau Kata : ");
    	String input = scan.nextLine();
    	
    	palindrome.setKalimat(input);
    	
    	scan.close();
    	
    	return palindrome;
    }
    
}
