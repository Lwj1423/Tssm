package JavaBase.demo;

/**
 * 银行有一个账户：
 *      有两个客户分别向同一个账户存3000元，每次存1000，存三次
 *      分析：
 *          1.有多线程问题
 *          2.有共享数据
 *          3.有线程安全
 */
public class AccountTest {
    public static void main(String[] args) {
        Account2 acct = new Account2(0);
        Customer2 c1 = new Customer2(acct);
        Customer2 c2 = new Customer2(acct);

        c1.setName("甲");
        c2.setName("乙");

        c1.start();
        c2.start();
    }
}

class Account2{
    private double balance;//账户余额

    public Account2(double balance) {
        this.balance = balance;
    }
    public synchronized void  deposit(double amt){
        if (amt > 0){
            balance += amt;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"存钱成功:" + balance);
        }
    }

}

class Customer2 extends Thread{

    private Account2 acct;

    public Customer2(Account2 acct) {
        this.acct = acct;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            acct.deposit(1000);
        }
    }
}
