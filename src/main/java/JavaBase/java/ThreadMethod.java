package JavaBase.java;

import static java.lang.Thread.yield;

/**
 * 线程常用方法
 *      yield(): 释放当前cpu执行权
 * 		join(): 在线程a中调用线程b的join(),此时线程a进入阻塞,直到线程B执行结束
 * 		stop(): 被淘汰
 */
public class ThreadMethod {

    public static void main(String[] args) {
        HelloThread helloThread = new HelloThread();
        helloThread.setName("线程命名");
        helloThread.start();


            for (int i = 0; i < 1000; i++) {
                if (i % 2 != 0) {
                    System.out.println(Thread.currentThread().getName());
                }
                if (i % 20 == 0) {
                    Thread.currentThread().yield();
                }
            }

        //线程级别
        System.out.println(helloThread.getPriority());
    }
}

class HelloThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 1000; i ++){
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getPriority()+"1111" + Thread.currentThread().getName());
            }

        }

    }
}