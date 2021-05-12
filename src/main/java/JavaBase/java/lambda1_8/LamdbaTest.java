package JavaBase.java.lambda1_8;

import org.junit.Test;

import java.util.Comparator;

/**
 * Lambda 表达式 练习
 */
public class LamdbaTest {

   //语句输出
    @Test
    public void test01(){
        Runnable r1 = new Runnable(){

            @Override
            public void run() {
                System.out.println("普通方式");
            }
        };

        r1.run();

        Runnable r2 = () -> System.out.println("lamdba表达式");

        r2.run();
    }

    //比较大小
    @Test
    public void test02(){
        Comparator<Integer> r1 = new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };

        System.out.println(r1.compare(12,21));;
        //lambda表达式
        Comparator<Integer> r2 = (o1,o2) -> Integer.compare(o1,o2);

        System.out.println(r2.compare(22, 23));

        //方法引用
        Comparator<Integer> r3 = Integer::compare;
        System.out.println(r3.compare(33, 32));
    }


}
