package JavaBase.java.TCPIP;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Tcp网络编程
 *  例1: 客户端发送信息给服务端
 *       服务端显示数据
 */
public class TcpTest01 {

        //客户端
        @Test
        public void client(){
            Socket socket = null;
            OutputStream os = null;
            //指定IP
            try {
                InetAddress inet = Inet4Address.getByName("127.0.0.1");
                //指定端口
                socket = new Socket(inet, 8800);
                os = socket.getOutputStream();
                os.write("你好,我是客户端".getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
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

            ByteArrayOutputStream baos = null;
            try {
                ss = new ServerSocket(8800);
                socket = ss.accept();
                is = socket.getInputStream();

                baos = new ByteArrayOutputStream();
                byte[] bytes = new byte[10];
                int len ;
                while ((len = is.read(bytes)) != -1){
                    baos.write(bytes,0,len);
                }
                System.out.println(baos.toString());
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
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
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }



}
