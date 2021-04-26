package JavaBase.java.IO;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Reader 字符流操作
 */
public class FileReaderTest {

    /**
     * reader写方法一
     * @throws IOException
     */
    @Test
    public void testFileReader()  {
        File file = new File("E:\\ssm\\src\\main\\java\\JavaBase\\java\\IO\\aaa.txt");
        FileReader reader = null;
        try {
            reader = new FileReader(file);

            //方式一
      /*  int data = reader.read();
        while (data != -1){
            System.out.println(data);
            data = reader.read();
        }*/

            //方式二
            int data = reader.read();
            while ((data = reader.read()) != -1){
                System.out.println(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    /**
     * reader写方法二
     * @throws IOException
     */
    @Test
    public void testFileReader2() throws IOException {
        File file = new File("E:\\ssm\\src\\main\\java\\JavaBase\\java\\IO\\aaa.txt");
        FileReader reader = null;
        try {
            reader = new FileReader(file);
            //方式二
            char[] cbuf = new char[5];
            int len;
            while ((len = reader.read(cbuf)) != -1){
                //方式一
                //不能写cbuf.length
                for (int i = 0; i < len; i++){
                    System.out.print(cbuf[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    }
