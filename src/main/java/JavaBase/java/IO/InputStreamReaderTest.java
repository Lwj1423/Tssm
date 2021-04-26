package JavaBase.java.IO;

import java.io.*;

/**
 * 转换流
 */
public class InputStreamReaderTest {

    public static void main(String[] args) {

        //读取源文件("UTF-8") 并转换为 "GBK"
        File file1 = new File("hello.txt");
        File file2 = new File("hello_gbk.txt");
        InputStreamReader isr = null;
        OutputStreamWriter osw = null;
        try {
            //字节流
            FileInputStream fis = new FileInputStream(file1);
            FileOutputStream fos = new FileOutputStream(file2);

            //转换流
            isr = new InputStreamReader(fis, "utf-8");
            osw = new OutputStreamWriter(fos, "gbk");

            //读写过程
            char[] cbuf = new char[1024];
            int len ;
            while ((len = isr.read(cbuf))!= -1) {
                osw.write(cbuf,0,len);
            }
            } catch (IOException e) {
            e.printStackTrace();
        }  finally {
            try {
                isr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                osw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
