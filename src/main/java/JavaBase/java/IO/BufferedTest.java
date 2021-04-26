package JavaBase.java.IO;

import java.io.*;

/**
 * 视频   加密  解密
 */
public class BufferedTest {

    public static void main(String[] args) {

        String srcPath = "E:\\test01\\10803.mp4";
        String destPath = "E:\\test01\\10806.mp4";
        copyFileWithBuffered(srcPath,destPath);

       /* String srcPath = "E:\\ssm\\hello.txt";
        String destPath = "E:\\ssm\\hello1.txt";

        copyFileWithBuffered2(srcPath,destPath);*/

    }


    //字节流文本复制
    public static void copyFileWithBuffered(String srcPath,String destPath){
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            File srcFile = new File(srcPath);    //文件
            File destFile = new File(destPath);

            FileInputStream fis = new FileInputStream(srcFile);  //字节读取
            FileOutputStream fos = new FileOutputStream(destFile);

            bis = new BufferedInputStream(fis); //加缓存
            bos = new BufferedOutputStream(fos);

            byte[] buffer = new byte[1024];
            int len ;
            while ((len = bis.read(buffer))!= -1){

                //加密操作
                for (int i = 0; i < len; i ++){
                    buffer[i] = (byte) (buffer[i] ^ 5);
                }


                bos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bos!= null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bis!= null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                ;
            }
        }
    }

    //字符流文本复制
    public static void copyFileWithBuffered2(String srcPath,String destPath){
        BufferedReader br = null;
        BufferedWriter bw = null;

        try {

            br = new BufferedReader(new FileReader(new File(srcPath)));
            bw = new BufferedWriter(new FileWriter(new File(destPath)));

           /* char[] ch = new char[1024];
            int len ;
            while ((len = br.read(ch))!= -1){
                bw.write(ch,0,len);
            }*/
           String data;
           while ((data = br.readLine()) != null){
               bw.write(data);
               bw.newLine();//换行
           }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br!= null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bw!= null){
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                ;
            }
        }
    }


}
