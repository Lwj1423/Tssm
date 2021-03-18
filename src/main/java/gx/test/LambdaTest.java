package gx.test;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

public class LambdaTest {

    //无参数
    @Test
    public void test1(){
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("这是一个普通无参无返回值方法");
            }
        };
        r1.run();
        System.out.println("*****************");

        Runnable r2 = () -> System.out.println("这是lambda 无参方法");
        r2.run();

    }

    @Test
    public void test2(){
        Consumer<String> con = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con.accept("有一个参数,无返回值!!!");
        System.out.println("********************************");
        Consumer<String> con1 = System.out::println;
        con1.accept("有一个参数,无返回值!!!");
    }

    @Test
    public void test3(){
        Consumer<String> con = System.out::println;
        con.accept("数据类型省略,由编译器推断出!!!");
    }


    @Test
    public void test4(){
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println(o1);
                System.out.println(o2);
                return o1.compareTo(o2);
            }
        };
        System.out.println(com1.compare(12,33));
        System.out.println("**********************");
        Comparator<Integer> com2 = (o1,o2) -> {
            System.out.println(o1);
            System.out.println(o2);
            return o1.compareTo(o2);
        };
        System.out.println(com2.compare(60,12));
    }


    @Test
    public void test5(){
        Comparator<Integer> com1 = Integer::compareTo;

        System.out.println(com1.compare(12,33));

    }
}
