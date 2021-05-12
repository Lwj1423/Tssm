package JavaBase.java.Stream;

import JavaBase.java.demo.Employee;
import JavaBase.java.demo.EmployeeData;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 测试Stream的中间操作
 */
public class StreamAPITest1 {

    //筛选  切片
    @Test
    public void test1(){
        List<Employee> employees = EmployeeData.getEmployees();
        //    filter(Predicate p): 接受数据,从流中排除某些元素
        employees.stream().filter(e -> e.getSalary() > 2000).forEach(System.out::println);
        System.out.println();
        //    limit(n): 截断流: 使元素不超过给定数量
        employees.stream().limit(3).forEach(System.out::println);
        System.out.println();
        //    skip(n):  跳过元素
        employees.stream().skip(3).forEach(System.out::println);

        //    distinct: 筛选,去重
        employees.add(new Employee(1001,"aa",34,7000));
        employees.add(new Employee(1001,"aa",34,7000));
        employees.add(new Employee(1001,"aa",34,7000));
        employees.add(new Employee(1001,"aa",34,7000));

        System.out.println(employees);
        System.out.println();
        employees.stream().distinct().forEach(System.out::println);

    }

    //映射
    @Test
    public void test2(){
        //map(Function f)--- 接受一个函数作为参数,返回新数字
        List<String> list = Arrays.asList("aa", "bb", "cc");
        list.stream().map(str -> str.toUpperCase());
            //练习:  获取员工姓名长度大于3的员工姓名
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<String> stringStream = employees.stream().map(e -> e.getName());
        stringStream.filter(name -> name.length() > 3).forEach(System.out::println);


        //flatMap(Function f)--- 接受一个函数作为参数,将流中数据换成新流,并返回
        Stream<Character> characterStream1 = list.stream().flatMap(StreamAPITest1::fromStringToStream);
        characterStream1.forEach(System.out::println);

        //练习2:
        Stream<Stream<Character>> characterStream = list.stream().map(StreamAPITest1::fromStringToStream);
        characterStream.forEach(s->{
            s.forEach(System.out::println);
        });

    }

    public static Stream<Character> fromStringToStream(String str){
        ArrayList<Character> list = new ArrayList<>();
        for (Character c :str.toCharArray()) {
            list.add(c);
        }

        return list.stream();
    }


    //排序
    @Test
    public void test3(){
        //sorted() - 自然排序
        List<Integer> integers = Arrays.asList(12, 33, 23, 44, 55, 6);
        integers.stream().sorted().forEach(System.out::println);

        //sorted(Comparator com)  定制排序
        List<Employee> employees = EmployeeData.getEmployees();
        employees.stream().sorted((e1,e2) -> {
            int ageValue = Integer.compare(e1.getAge(), e2.getAge());
            if (ageValue != 0){
                return ageValue;
            }else {
                return -Double.compare(e1.getSalary(),e2.getSalary());
            }
        }).forEach(System.out::println);

    }
    @Test
    public void test4(){
        System.out.println(Integer.compare(1, 1));
    }
}
