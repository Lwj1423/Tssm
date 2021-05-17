package JavaBase.java.Map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

/**
 *
 * Map类练习
 */
public class Map {


    /**
     * 遍历
     */
    @Test
    public void test01(){
        HashMap<Object, Object> map = new HashMap<>();
        map.put("1","001");
        map.put(2,3);
        map.put(3,4);
        map.put("2","002");
        map.put("3","003");
        map.put("4","004");

        //遍历:方法一
        Set<java.util.Map.Entry<Object, Object>> entrySet = map.entrySet();
        Iterator<java.util.Map.Entry<Object, Object>> iterator = entrySet.iterator();
        while (iterator.hasNext()){
            java.util.Map.Entry<Object, Object> entry = iterator.next();
            System.out.println(entry.getKey() + "-----" + entry.getValue());
        }

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

    }
}
