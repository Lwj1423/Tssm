package JavaBase.mainUtil;

/**
 * 自定义String方法
 */
public class StringUtil {
    /**
     * 将字符串指定位置进行反转
     * @param str
     * @param startIndex
     * @param endIndex
     * @return
     */
    public static String reverse(String str,int startIndex,int endIndex){
        if (str != null) {
            StringBuilder sb = new StringBuilder(str.length());
            sb.append(str.substring(0, startIndex));
            for (int i = endIndex; i >= startIndex; i--) {
                sb.append(str.charAt(i));
            }
            sb.append(str.substring(endIndex + 1));
            return sb.toString();
        }
        return null;
    }

    public static int getCount(String mainStr,String subStr){
        int mainLength = mainStr.length();
        int subLength = subStr.length();
        int count = 0;
        int index = 0;
        if (mainLength >= subLength){
            //indexof（）查找subStr第一次出现的位置
         while ((index = mainStr.indexOf(subStr,index)) != -1)
            count++;
            index += subLength;
        }
        return count;
    }
}
