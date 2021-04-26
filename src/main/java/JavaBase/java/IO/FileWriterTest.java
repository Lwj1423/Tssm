package JavaBase.java.IO;

import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Writer字符流 操作
 */
public class FileWriterTest {

    @Test
    public void writer01(){
        File file = new File("hello.txt");

        FileWriter fw = null;
        try {
            fw = new FileWriter(file);

            fw.write("aaaaa");
            fw.write("bbbbb");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fw != null){
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
