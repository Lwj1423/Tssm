package gx.test;

import gx.domain.Account;
import gx.service.DemoService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestSpring {

    @Test
    public void run1(){
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        DemoService as = (DemoService) ac.getBean("demoService");
        List<Account> all = as.findAll();
        for (Account account : all) {
            System.out.println(account);
        }
    }
}
