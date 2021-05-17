package JavaBase.test;


import JavaBase.mainUtil.StringUtil;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Test01 {

    @Test
    public void test01(){
        A.getA();
        System.out.println("1111");
    }

    @Test
    public void test02(){
        HashMap<Object, Object> map = new HashMap<>();
        map.put("1","001");
        map.put(2,3);
        map.put(3,4);
        map.put("2","002");
        map.put("3","003");
        map.put("4","004");
        System.out.println(map);
        HashMap<Object, Object> map2 = new LinkedHashMap<>();
        map2.put("1","001");
        map2.put(2,3);
        map2.put(3,4);
        map2.put("2","002");
        map2.put("3","003");
        map2.put("4","004");
        System.out.println(map2);

        HashSet<Object> set = new HashSet<>();

    }

    @Test
    public void test03(){
        String s1 = "222ababababac";
        int a = s1.indexOf("ab");
        System.out.println(a);
    }
    @Test
    public void test04(){
        String s1 = "abc11223344";
        String s2 = StringUtil.reverse(s1,3,6);
        System.out.println(s2);


    }

    @Test
    public void test05(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = new Date();
        String format = sdf.format(date);
        System.out.println(format);
    }
    @Test
    public void test06(){
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter ofForMat = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        System.out.println(ofForMat.format(dateTime));
    }


    @Test
    public void test07(){
        sum(10000);
    }

    //递归
    void sum(int n){
        if (n >= 0){
            sum(n-1);
            System.out.println(n);
        }else{
            return;
        }

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
