package JavaBase.demo;

/**
 * 模拟卖票 继承Thread  线程方式一：
 */
public class TicketTest02 extends  Thread {

    public static  int ticket = 100;

    @Override
    public void run() {
        while (true) {
            //同步锁  this必须为唯一对象，可用A.class 类来充当
            synchronized (TicketTest02.class) {
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
            }
        }
    }
}

class ThreadTest2{
    public static void main(String[] args) {
        TicketTest02 test1 = new TicketTest02();
        TicketTest02 test2 = new TicketTest02();
        TicketTest02 test3 = new TicketTest02();

        test1.start();
        test2.start();
        test3.start();
    }
}
