package JavaBase.java.lambda1_8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Lambda 表达式 练习2
 *
 * 函数式接口编程  才可以使用lambda表达式
 */
public class LamdbaTest02 {

    @Test
    public void test01(){
        happyTime(500, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("花钱" + aDouble);
            }
        });
        happyTime(400,s -> System.out.println(s));


    }

    //Consumer  接口
    public void happyTime(double money, Consumer<Double> con){
        con.accept(money);
    }

    @Test
    public void test02(){
        List<String> list = Arrays.asList("南京","西京","上海");
        List<String> filterList = filterString(list, s -> s.contains("京"));
        System.out.println(filterList);
    }

    //Predicate  接口
    public List<String> filterString(List<String> list, Predicate<String> pre){
        ArrayList<String> filterList = new ArrayList<>();

        for (String s:list) {
            if (pre.test(s)){
                filterList.add(s);
            }
        }

        return filterList;
    }
}
