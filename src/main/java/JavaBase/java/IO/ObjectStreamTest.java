package JavaBase.java.IO;

import org.junit.Test;

import java.io.*;

/**
 * 对象流的使用  序列化 和 反序列化
 */
public class ObjectStreamTest {

    /**
     * 对象序列化 将对象写入txt文件中
     */
    @Test
    public void testObjectOutput(){
        ObjectOutputStream oos = null;

        try {
            oos = new ObjectOutputStream(new FileOutputStream("String.text"));
            oos.writeObject(new String("对象流序列化"));
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    /**
     * 对象反序列化 将对象从txt文件中获取出来
     */
    @Test
    public void testObjectInput(){
        ObjectInputStream ois = null;

        try {
            ois = new ObjectInputStream(new FileInputStream("String.text"));
            Object object = ois.readObject();
            String str = (String) object;
            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
