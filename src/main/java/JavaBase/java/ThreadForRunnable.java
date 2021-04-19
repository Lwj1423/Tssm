package JavaBase.java;
/**
 * 多线程的创建 方法二
 *方法二：实现Runnable接口的类
 */
//1.创建一个实现了Runnable接口的类
public class ThreadForRunnable implements Runnable {

    //2.实现类中实现run方法

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++){
            if (i % 2 == 0){
                System.out.println(i);
            }
        }
    }
}

class ThreadTest1 {
    public static void main(String[] args) {
        //3.创建实现类对象
        ThreadForRunnable th = new ThreadForRunnable();
        //4.作为传参传值
        Thread thread = new Thread(th);
        //通过Thread对象调用start对象
        thread.start();
    }
}