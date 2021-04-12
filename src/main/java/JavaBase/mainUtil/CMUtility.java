package JavaBase.mainUtil;

import java.util.Scanner;

public class CMUtility {
    private static Scanner scanner = new Scanner(System.in);

    //获取‘1-5’中的任意字符
    public static char readMenuSelection(){
        char c;
        for (; ; ){
            String str = readKeyBoard(1,false);
            c = str.charAt(0);
            if (c != '1' && c !='2' &&
                 c != '3' && c != '4' && c != '5'){
                System.out.println("选择错误，请重新输入： ");
            }else break;
        }
        return c;
    }

    //从键盘获取一个字符，并作为方法返回值
    public static char readChar(char defaultValue){
        String str = readKeyBoard(1,true);
        return (str.length() == 0) ? defaultValue : str.charAt(0);
    }

    //从键盘获取长度不超过2位的整数，并作为方法返回值
    public static int readInt(){
        int n;
        for (; ; ){
            String str = readKeyBoard(2,false);
            try {
                n = Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                System.out.println("数字输入错误，请重新输入： ");
            }
        }
        return n;
    }

    //从键盘获取长度不超过2位的整数，并作为方法返回值
    //默认值defauleValue
    public static int readInt(int defaultValue){
        int n;
        for (; ; ){
            String str = readKeyBoard(2,false);
            if (str.equals(""))
                return defaultValue;
            try {
                n = Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                System.out.println("数字输入错误，请重新输入： ");
            }
        }
        return n;
    }

    //从键盘获取不超过limit的值，并作为方法返回值
    public static String readString(int limit){
        return readKeyBoard(limit,false);
    }

    //从键盘获取不超过limit的值，为空设置默认值
    public static String readString(int limit,String defaultValue){
       String str = readKeyBoard(limit,true);
        return (str.equals("") ? defaultValue : str);
    }



    //用于确定选择的输入，该方法从键盘获取‘Y’/‘N’
    public static char readConfirmSelection(){
        char c;
        for (; ; ){
            String str =readKeyBoard(1,false).toUpperCase();
            c = str.charAt(0);
            if (c == 'Y' || c == 'N'){
                break;
        } else {
                System.out.println("选择错误，请重新输入： ");
            }

    }
        return c;
}


    public static String readKeyBoard(int limit, boolean b) {
        String line = "";

        while (scanner.hasNextLine()){
            line = scanner.nextLine();
            if (line.length() == 0){
                if (b) return line;
                else continue;
            }

            if (line.length() < 1 || line.length() > limit){
                System.out.println("输入长度（不大于"+limit+")错误");
                continue;
            }
            break;
        }
        return line;
    }


}
