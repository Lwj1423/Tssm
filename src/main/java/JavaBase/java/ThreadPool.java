package JavaBase.java;

import java.util.concurrent.*;

/**
 * 创建线程方式四: 使用线程池
 *
 */
public class ThreadPool {
    public static void main(String[] args) {
        //1.提供指定数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        //设置参数操作
      /*  ThreadPoolExecutor service1 = (ThreadPoolExecutor) service;
        service1.setCorePoolSize(15);*/

        //2.执行指定的线程池操作
        service.execute( new NumberThread());
        service.execute( new NumberThread1());
        //service.submit();  适合于Callable
        //3.关闭连接池
        service.shutdown();

    }
}

class NumberThread implements Runnable{
    @Override
    public void run() {
        synchronized (NumberThread.class) {
            for (int i = 0; i <= 100; i++) {
                if (i % 2 == 0) {
                    Thread.yield();
                    System.out.println(Thread.currentThread().getName() + ":" + i);
                }
            }
        }
    }
}

class NumberThread1 implements Runnable{
    @Override
    public void run() {
        synchronized (NumberThread.class) {
            for (int i = 0; i <= 100; i++) {
                if (i % 2 == 0) {
                    Thread.yield();
                    System.out.println(Thread.currentThread().getName() + ":" + i);
                }
            }
        }
    }
}