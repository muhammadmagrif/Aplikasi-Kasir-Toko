package xa.ioctest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import xa.ioctest.classes.HelloWorld;
import xa.ioctest.configurations.Application;

@SpringBootApplication
public class IoctestApplication {

	public static void main(String[] args) {
		//SpringApplication.run(IoctestApplication.class, args);
        // ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
        HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
        obj.getMessage();
        context.close();	
    }

}
