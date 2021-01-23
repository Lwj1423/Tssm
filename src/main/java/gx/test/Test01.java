package gx.test;

import org.junit.Test;

import java.sql.SQLOutput;


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
        String str ="1";
        String[] str1 = str.split(",");
        for (String a: str1
             ) {
            System.out.println(a);
        }


    }
}
