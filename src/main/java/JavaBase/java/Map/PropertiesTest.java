package JavaBase.java.Map;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Properties;

/**
 * Properties属性
 */
public class PropertiesTest {

    //properties:用来处理配置文件
    public static void main(String[] args) throws IOException {
        Properties pros = new Properties();

        FileInputStream stream = new FileInputStream("E:\\ssm\\src\\aa.properties");
        InputStreamReader reader = new InputStreamReader(stream,"UTF-8");
        pros.load(reader);

        String name = pros.getProperty("name");
        String age = pros.getProperty("age");

        System.out.println(name + age);
        stream.close();


    }
}
