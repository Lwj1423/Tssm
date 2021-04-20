package JavaBase.java.Thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程安全三种方式
 * 模拟卖票   实现Runnable    同步方法
 *      问题: 卖票过程中,出现了重票、错票  线程安全问题
 *      解决方法  ：一个线程操作过程中，其他线程不能操作
 *          线程安全方法一： 同步代码块
 *              synchronized(同步监视器){
 *                  //需要被同步的代码
 *              }
 *              说明：1. 操作共享数据的代码，即为需要被同步的代码
 *                   2. 共享数据： 多个线程共同操作的变量
 *                   3. 同属监视器，俗称  锁（任何一个类的对象，都可以）
 *                           要求：多个线程必须要公用同一把锁
 *          方法二：同步方法
 *              将代码块抽象为方法，
 *              synchronized method(){
 *                  //需要被同步的代码
 *              }
 *
 */
public class SynchronizedTest implements Runnable {

    private int ticket = 100;
    //创建Lock
    private ReentrantLock lock = new ReentrantLock(true);


    @Override
    public void run() {
        while (true) {
            //同步锁  方法一：同步代码块 this必须为唯一对象，可用A.class 类来充当
            /*synchronized (this) {
                if (ticket > 0) {

                    try {
                        //模拟出现错票
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + "卖票,票号为:" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }*/

            //  方法三：Lock（）
            lock.lock();
            if (ticket > 0) {
                try {
                    //模拟出现错票
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + "卖票,票号为:" + ticket);
                ticket--;
            } else {
                break;
            }
            lock.unlock();
        }
    }

    //同步锁 方法二：同步方法
    public synchronized void method(int ticket){
        if (ticket > 0) {

            try {
                //模拟出现错票
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "卖票,票号为:" + ticket);
            ticket--;
        }
    }
}

class TicketTest1 {
    public static void main(String[] args) {
        SynchronizedTest t = new SynchronizedTest();

        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        Thread t3 = new Thread(t);

        t1.start();
        t2.start();
        t3.start();
    }
}
