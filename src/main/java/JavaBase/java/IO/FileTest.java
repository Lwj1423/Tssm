package JavaBase.java.IO;

import org.junit.Test;

import java.io.*;
import java.util.Properties;

public class FileTest {

    @Test
    public void Test1() throws IOException {
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
