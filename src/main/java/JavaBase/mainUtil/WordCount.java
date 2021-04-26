package JavaBase.mainUtil;

import org.junit.Test;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 获取文本上字符出现的次数
 *
 * 1.遍历文本每一个字符
 * 2. 字符出现的次数存在Map中
 * 3. 把map中数据写入文件
 */
public class WordCount {

    @Test
    public void testWordCount(){
        FileReader fr = null;
        BufferedWriter bw = null;

        try {
            //创建map
            HashMap<Character, Integer> map = new HashMap<>();
            fr = new FileReader("E:\\ssm\\hello.txt");

            //遍历每个字符,map统计出现次数
            int c = 0;
            while ((c = fr.read()) != -1){
                char ch = (char) c;
                //判断是否在map中第一次出现
                if (map.get(ch) == null){
                    map.put(ch,1);
                }else{
                    map.put(ch,map.get(ch) +1);
                }
            }

            //把map中数据存在文件中count.txt
            bw = new BufferedWriter(new FileWriter("count.txt"));

            //遍历map,写入数据
            Set<Map.Entry<Character, Integer>> entrySet = map.entrySet();
            for (Map.Entry<Character, Integer> entry:
            entrySet) {
                switch (entry.getKey()){
                    case ' ':
                        bw.write("空格="+entry.getValue());
                        break;
                    case '\t':
                        bw.write("tab键="+entry.getValue());
                        break;
                    case '\r':
                        bw.write("回车="+entry.getValue());
                        break;
                    case '\n':
                        bw.write("换行="+entry.getValue());
                        break;
                    default:
                        bw.write(entry.getKey()+"="+entry.getValue());
                        break;
                }
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fr != null){
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bw != null){
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
