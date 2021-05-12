package JavaBase.java.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * 提供测试的数据
 */
public class EmployeeData {

    public static List<Employee> getEmployees(){
        List<Employee> list = new ArrayList<>();

        list.add(new Employee(1001,"aa",34,7000));
        list.add(new Employee(1002,"bbbb",10,6000));
        list.add(new Employee(1003,"cc",20,5000));
        list.add(new Employee(1004,"dd",30,4000));
        list.add(new Employee(1005,"ee",40,3000));
        list.add(new Employee(1006,"ffff",33,2000));
        list.add(new Employee(1007,"gg",22,1000));


        return list;
    }
}
