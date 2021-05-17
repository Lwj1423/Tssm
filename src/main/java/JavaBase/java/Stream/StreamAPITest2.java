package JavaBase.java.Stream;

import JavaBase.java.demo.Employee;
import JavaBase.java.demo.EmployeeData;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 终止操作
 */
public class StreamAPITest2 {

    // 1.匹配与排序
    @Test
    public void test1(){
        List<Employee> employees = EmployeeData.getEmployees();

        //allMatch 判断所有age是否都大于 10   匹配所有
        boolean all = employees.stream().allMatch(e -> e.getAge() > 10);
        System.out.println(all);

        //anyMatch 判断所有age 有没有 10  匹配至少一个
        boolean anyMatch = employees.stream().anyMatch(e -> e.getAge() > 10);
        System.out.println(anyMatch);

        //noneMatch  检查是否没有匹配
        boolean none = employees.stream().noneMatch(e -> e.getAge() < 10);
        System.out.println(none);

        //noneMatch  匹配第一个
        Optional<Employee> first = employees.stream().findFirst();
        System.out.println(first);

        //noneMatch  匹配任意
        Optional<Employee> any = employees.parallelStream().findAny();
        System.out.println(any);

        //count   返回流中总个数
        long count = employees.stream().filter(e -> e.getAge() > 10).count();
        System.out.println(count);

        //max(Comparator c) -返回流中最大值
        //练习: 返回最高的工资
        Stream<Double> doubleStream = employees.stream().map(e -> e.getSalary());
        Optional<Double> max = doubleStream.max(Double::compareTo);
        System.out.println("最高:" + max);

    }


    // 2. 规约
    @Test
    public void test2(){
        //reduce(T identity, BinaryOperator) 对流中元素反复求和
        //计算1-10 的和
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        Integer sum = integers.stream().reduce(0, Integer::sum);
        System.out.println(sum);

        //将流中数据反复求和，得到一个值
        //求员工工资
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<Double> doubleStream = employees.stream().map(Employee::getSalary);
        Optional<Double> sumMoney = doubleStream.reduce((d1, d2) -> d1 + d2);
        System.out.println(sumMoney.get());
    }

    // 3. 收集
    @Test
    public void test3(){
        //collect（Collector c）将 查询结果返回一个list或set
        //练习： 查找工资大于6000的员工，结果返回又给List或Set
        List<Employee> employees = EmployeeData.getEmployees();
        List<Employee> collect = employees.stream().filter(e -> e.getSalary() > 3000).collect(Collectors.toList());
        for (Employee employee:
             collect) {
            System.out.println(employee);
        }


        Set<Employee> collect1 = employees.stream().filter(e -> e.getSalary() > 3000).collect(Collectors.toSet());
        for (Employee employee:
                collect1) {
            System.out.println(employee);
        }
    }
}
