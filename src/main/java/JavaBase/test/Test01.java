package JavaBase.test;

import org.junit.Test;

public class Test01 {

    @Test
    public void test01(){
        A.getA();
        System.out.println("1111");
    }
}

interface A{

     static void getA(){
        System.out.println("333");
    }

     default void getB(){
        System.out.println("444");
    }
}
