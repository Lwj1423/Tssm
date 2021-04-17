package JavaBase.java;

/**
 * 多线程的创建 方法一
 *
 */

public class Thread {
    public static void main(String[] args) {
        //3.创建子类对象
        MyThread myThread = new MyThread();
        //4.调用start()
        // 线程一
        myThread.start();
        //线程二
        for (int i = 0; i < 50; i++){
            if (i % 2 == 0){
                System.out.println(java.lang.Thread.currentThread().getName() + ":" + i);
            }

        }
    }
}

//方法一：继承Thread类
//1.继承Thread
class MyThread extends java.lang.Thread {
    //2.重写Thread类的run()
    @Override
    public void run() {
        for (int i = 0; i < 100; i++){
            if (i % 2 == 0){
                System.out.println(java.lang.Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}
