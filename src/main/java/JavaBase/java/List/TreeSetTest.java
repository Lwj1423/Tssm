package JavaBase.java.List;

import org.junit.Test;

import java.util.HashSet;
import java.util.Objects;

/**
 * TreeSet经典面试题
 * 1.先判断hashCode,再判断equlas()
 *
 * Person 必须重写hashCode()和equals()
 */
public class TreeSetTest {

    @Test
    public void test(){
        HashSet<Object> set = new HashSet<>();
        Person p1 = new Person(1001, "AA");
        Person p2 = new Person(1002, "bb");

        set.add(p1);
        set.add(p2);
        System.out.println(set);

        p1.name = "CC";
        set.remove(p1);
        //删不掉
        System.out.println(set);
        set.add(new Person(1001,"CC"));
        System.out.println(set);
        set.add(new Person(1001,"AA"));
        System.out.println(set);
    }
}

class Person{
    int age;
    String name;

    public Person(int id,String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }
}
