package JavaBase.java;

/**
 * 自定义异常类
 */
public class MyException extends Exception {

    //定义全局常量
    static final long serialVersionUID = -7034897190745766939L;

    public MyException() {
    }

    //重载构造器
    public MyException(String msg){
        super(msg);
    }
}
