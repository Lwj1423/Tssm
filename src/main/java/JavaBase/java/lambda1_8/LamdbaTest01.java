package JavaBase.java.lambda1_8;

import org.junit.Test;

import java.util.function.Consumer;

/**
 * Lambda 表达式 练习1
 *
 * 6中格式
 */
public class LamdbaTest01 {

    //格式一：无参，无返回值
    @Test
    public void test1(){
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("1111");
            }
        };
        r1.run();

        Runnable r2 = () -> System.out.println("测试");
        r2.run();
    }

    //格式二：有一个参数，无返回值
    @Test
    public void test2(){
        Consumer c1 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        c1.accept("1111");

        //包含类型推断
        //Consumer<String> c2 = (String s) -> System.out.println(s);
        Consumer<String> c2 = (s) -> System.out.println(s);
        c2.accept("2222");
    }


}
