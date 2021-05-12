package JavaBase.java.TCPIP;

import org.junit.Test;

import java.io.*;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
/*
    Tcp网络编程
 *  例2: 客户端发送图片给服务端
 *       服务端保存图片
 */
public class TcpTest02 {

    //客户端
    @Test
    public void client(){
        Socket socket = null;
        OutputStream os = null;
        FileInputStream fis = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;

        try {
            //指定IP
            InetAddress inet = Inet4Address.getByName("127.0.0.1");
            //指定端口
            socket = new Socket(inet, 8800);
            //获取字节流
            os = socket.getOutputStream();
            fis = new FileInputStream(new File("E:\\ssm\\4.jpg"));

            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) != -1){
                os.write(buffer,0,len);
            }
            //手动结束传输
            socket.shutdownOutput();

            //接受来自服务器端的数据
            is = socket.getInputStream();
            baos = new ByteArrayOutputStream();
            byte[] bytes = new byte[20];
            int len1 ;
            while ((len1 = is.read(bytes)) != -1){
                baos.write(bytes,0,len1);
            }
            System.out.println(baos.toString());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    @Test
    //服务端
    public void server(){
        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        OutputStream os = null;

        FileOutputStream fos = null;
        try {
            //1.socket服务器
            ss = new ServerSocket(8800);
            //2.接受数据
            socket = ss.accept();
            //3.
            is = socket.getInputStream();
            //4.
            fos = new FileOutputStream(new File("E:\\ssm\\005.jpg"));
            //5
            byte[] bytes = new byte[10];
            int len ;
            while ((len = is.read(bytes)) != -1){
                fos.write(bytes,0,len);
            }

            //6.给服务器端反馈
            os = socket.getOutputStream();
            os.write("数据已经收到".getBytes());



        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                ss.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
