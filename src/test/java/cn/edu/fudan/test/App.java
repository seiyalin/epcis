package cn.edu.fudan.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main( String[] args )
    {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("classpath:test-springl.xml");
        PersonService service = appContext.getBean(PersonService.class);
        Person p = service.getPerson(1);
        System.out.println(p.getName());
    }
}
