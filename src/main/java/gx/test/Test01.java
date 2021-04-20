package gx.test;

import JavaBase.demo.BankTest;
import org.junit.Test;


public class Test01 {




    //
    @Test
    public  void test011() {

        int a = 13;
        int b = 5;
        int c = b %a;

        System.out.println("完成" + c);
    }
    @Test
    public void test02(){

        String k = "";
        for(int i=0;i<10;i++){
            k = k+i;

        }
        System.out.println(k);
    }



    @Test
    public void test04(){
        String str = new String("111");
        String str1 = new String("111");
        System.out.println(str.equals(str1));



        BankTest bankTest = new BankTest();
        BankTest bankTest1 = new BankTest();
        System.out.println(bankTest.equals(bankTest1));
    }

    @Test
    public void test05(){
        boolean x = true;
        boolean y = false;
        short z = 42;
        //if(y==true)
        //if ((z++==42)&&(y=true))z++;
        //if ((x=false)||(++z==45))z++;

        System.out.println("z="+z);
    }


}
