package project01.view;

import java.util.Scanner;

/**
 * 方便的实现键盘访问
 */
public class TSUtility {
    private static Scanner scanner = new Scanner(System.in);

    /**
     * 读取键盘输入,'1-4'中任意字符,方法返回
     * @return
     */
    public static char readMenuSelection(){
        char c;
        for (; ; ){
            String str = readKeyBoard(1,false);
            c = str.charAt(0);
            if (c != '1' && c !='2' &&
                    c != '3' && c != '4'){
                System.out.println("选择错误，请重新输入： ");
            }else break;
        }
        return c;
    }

    /**
     * 该方法提示并等待,直到用户回车键返回
     */
    public static void readReturn(){
        System.out.println("按回车键继续......");
        readKeyBoard(100,true);
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
