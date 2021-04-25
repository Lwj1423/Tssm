package JavaBase.java.List;

import org.junit.Test;

import java.util.*;

/**
 * Collection接口中方法使用
 */
public class CollectionTest {

    @Test
    public void getMethod() {
        Collection coll = new ArrayList();
        //add():添加数据
        coll.add("AA");
        coll.add("BB");
        coll.add(123);
        coll.add(new Date());

        //size():集合长度
        System.out.println(coll.size());

        //添加集合到原来集合中
        Collection coll1 = new ArrayList();
        coll1.add(345);
        coll.addAll(coll1);

        System.out.println(coll.size());
        System.out.println(coll);

        System.out.println(coll);
        Collection coll2 = Arrays.asList("AA", "BB");
        coll.removeAll(coll2);
        System.out.println(coll);
        //clear():清空元素
        //coll.clear();

        //isEmpty():判断是否为空
        //coll.isEmpty();
    }

}
