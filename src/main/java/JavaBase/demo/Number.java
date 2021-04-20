package JavaBase.demo;

/**
 * 线程通信的例子：使用两个线程打印1-100， 线程1、线程2,交替打印
 *
 *  涉及三个方法：
 *      wait（）：一旦执行此方法，线程就进入阻塞状态，并释放同步监视器（锁）
 * 			notify（）：一旦执行此方法，一个线程就被唤醒，如果有多个，按优先级释放一个
 * 			notifyAll（）:一旦执行此方法，所有线程就被唤醒
 *
 */
public class Number implements Runnable {

    private int number = 1;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                notify();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (number <= 100) {
                    System.out.println(Thread.currentThread().getName() + ":" + number);
                    number++;

                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }
        }
    }
}

class Test03 {
    public static void main(String[] args) {
        Number n1 = new Number();
        Thread t1 = new Thread(n1);
        Thread t2 = new Thread(n1);

        t1.setName("线程一");
        t2.setName("线程二");

        t1.start();
        t2.start();
    }
}
