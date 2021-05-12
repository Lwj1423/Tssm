package JavaBase.java.TCPIP;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * url获取值
 */
public class URLTest1 {

    public static void main(String[] args) {

        InputStream is = null;
        FileOutputStream fos = null;
        HttpURLConnection urlconn = null;

        try {
            URL url = new URL("http://localhost:8088/examples/4.jpg");
            urlconn = (HttpURLConnection) url.openConnection();
            urlconn.connect();

            is = urlconn.getInputStream();
            fos = new FileOutputStream("E:\\ssm\\src\\main\\java\\22.jpg");
            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer))!= -1){
                fos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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
            urlconn.disconnect();
        }
    }

}
