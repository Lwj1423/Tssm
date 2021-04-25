package JavaBase.java.List;

import java.util.*;

/**
 * 迭代器使用
 */
public class IteratorTest {

    public static void main(String[] args) {
        new HashSet<>();
        Collection coll = new ArrayList();
        //add():添加数据
        coll.add("AA");
        coll.add("BB");
        coll.add(123);
        coll.add(new Date());

        Iterator<Object> iterator = coll.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

}
