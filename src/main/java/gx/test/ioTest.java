package gx.test;

import org.junit.Test;

import java.io.*;
import java.util.Scanner;

public class ioTest {

    //字符流输出
    @Test
    public void zfouttest() throws IOException {

        //以标准输入作为扫描来源
        Scanner sc = new Scanner(System.in);
        File f = new File("E:\\test\\Test.txt");
        BufferedWriter bw = new BufferedWriter(new FileWriter(f));
        if (!f.exists()) {
            f.createNewFile();
        }
        while (true) {
            String s = sc.nextLine();
            bw.write(s);
            bw.flush();
            if (s.equals("结束") || s.equals("")) {
                System.out.println("写入数据结束！");
                return;
            }
        }
    }


    //字符流输入
    @Test
    public  void Test01() throws IOException {
            File f = new File("E:\\test\\Test.txt");
            if (f.exists()) { // 判断文件或目录是否存在
            if (f.isFile()) {
                BufferedReader br = new BufferedReader(new FileReader("E:\\test\\Test.txt"));//该缓冲流有一个readLine()独有方法
                String s = null;
                while ((s = br.readLine()) != null) {//readLine()每次读取一行
                    System.out.println(s);
                }
            }
        }
    }

    @Test
    public void test02(){

        label:for(int i = 1; i<= 40; i++){
            for (int j=1; j< 3; j++){
                if (i == j){
                    System.out.println(111);
                    break label;
                }
            }
            System.out.println(i);
        }


    }



}
