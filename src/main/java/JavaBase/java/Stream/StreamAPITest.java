package JavaBase.java.Stream;

import JavaBase.java.demo.Employee;
import JavaBase.java.demo.EmployeeData;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * stream实例化
 */
public class StreamAPITest {

    //方式一 :  通过集合
    @Test
    public void test1(){
        List<Employee> employees = EmployeeData.getEmployees();

        //返回一个顺序流
        Stream<Employee> stream = employees.stream();
        //返回一个并行流
        Stream<Employee> parallelStream = employees.parallelStream();
    }


    //方式二 :  通过数组
    @Test
    public void test2(){
        int[] arr = {1,2,3,4,5,6};
        IntStream stream = Arrays.stream(arr);

        Employee e1 = new Employee(1001,"aa");
        Employee e2 = new Employee(1002,"bb");
        Employee[] arr1 = {e1,e2};
        Stream<Employee> stream1 = Arrays.stream(arr1);
    }

    //方式三 :  通过of()
    @Test
    public void test3(){
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
    }

    //方式四 :  创建无限流
    @Test
    public void test4(){

        //遍历前10个偶数
        Stream.iterate(0,t -> t +2).limit(10).forEach(System.out::println);

        //遍历前10个偶数
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }
}

















