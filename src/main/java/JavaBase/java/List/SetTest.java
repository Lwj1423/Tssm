package JavaBase.java.List;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 使用hashSet对 List 去重
 */
public class SetTest {
    @Test
    public void test2(){
        ArrayList list = new ArrayList();
        list.add(new Integer(1));
        list.add(new Integer(2));
        list.add(new Integer(2));
        list.add(new Integer(3));
        list.add(new Integer(4));
        list.add(new Integer(5));

        List list1 = duplicateList(list);
        list1.forEach(item->System.out.println(item));
    }

    public static List duplicateList(List list){
        HashSet<Object> set = new HashSet<>();
        set.addAll(list);
        return new ArrayList(set);
    }


}
