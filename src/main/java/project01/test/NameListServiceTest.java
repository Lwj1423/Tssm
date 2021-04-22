package project01.test;

import JavaBase.java.MyException;
import org.junit.Test;
import project01.domain.Employee;
import project01.service.NameListService;

public class NameListServiceTest {

    //测试service中的方法
    @Test
    public void testGetAllEmployee(){
        NameListService service = new NameListService();
        Employee[] allEmployess = service.getAllEmployess();
        System.out.println("ID\t姓名\t年龄\t工资\t\t职位\t状态\t奖金\t股票\t\t\t设备" );
        for (Employee employee :
                allEmployess) {
            System.out.println(employee);
        }
    }

    //测试service中getEmployee();
    @Test
    public void getEmployeeTest(){
        int id = 10;
        NameListService service = new NameListService();
        try {
            Employee employee = service.getEmployee(id);
            System.out.println(employee);
        } catch (MyException e) {
            e.printStackTrace();
        }


    }

}
