package gx.test;

import gx.dao.DemoDao;
import gx.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;



public class TestSql {

    @Test
    public void run1() throws IOException {
        Account account =new Account();
        account.setName("杜永蓝");
        account.setMoney(200d);
        // 加载配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 创建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // 创建SqlSession对象
        SqlSession session = factory.openSession();
        // 获取到代理对象
        DemoDao dao = session.getMapper(DemoDao.class);

        // 保存
        dao.saveAccount(account);

        // 提交事务
        session.commit();

        // 关闭资源
        session.close();
        in.close();
    }

    @Autowired
    private DemoDao dao;

    @Test
    public void run2() throws Exception {


        //获取applicationContext文件并加载
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取StudentDao的bean
        DemoDao dao = (DemoDao) ac.getBean("demoDao");

        List<Account> list = dao.findAll();
        for (Account account: list ) {
            System.out.println(account);
        }

    }

}
