package JavaBase.java.Optional;

import org.junit.Test;

import java.util.Optional;

/**
 * Optional类  练习
 */
public class OptionalTest {

    @Test
    public void test1(){
        //empty():创建的Optional对象  value = null
        Optional<Object> op1 = Optional.empty();
        //封装的数据是否有数据
        System.out.println(op1.isPresent());
        System.out.println(op1.get());
    }

    @Test
    public void test2(){
        String str = "hello";
        //of(T t):封装数据 声称Optional   t不为空
        Optional<String> op1 = Optional.of(str);
        //get():获取Optional中封装的数据
        System.out.println(op1.get());
    }

    @Test
    public void test3(){
        String str = "beijign";
        str = null;
        //ofNullable(T t):封装数据 声称Optional   t可以为空
        Optional<String> op1 = Optional.ofNullable(str);
        //orElse(T t):如何str 为空，重新赋值
        System.out.println(op1.orElse("shanghai"));

    }
}
