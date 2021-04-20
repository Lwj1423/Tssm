package JavaBase.demo;

/**
 * 线程通信的应用:经典例题 生产者/消费者
 * 1.生产者将产品交给店员,店员出售给消费者
 * 2.产品对多有20个,多了生产者停止生产,小于零消费者禁止消费
 *
 */
public class ProductTest {
    public static void main(String[] args) {
        Product p = new Product();
        Producer producer = new Producer(p);
        producer.setName("生产者");
        Customer4 customer4 = new Customer4(p);
        customer4.setName("消费者");

        producer.start();
        customer4.start();
    }

}
class Product{ //产品

    private int totalCount = 0;

    public synchronized void creatProduct() {
        if (totalCount < 20){
            totalCount++;
            System.out.println(Thread.currentThread().getName() + "开始生产第:"+totalCount+ "个");

            //释放
            notify();
        }else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void consumProduct() {
        if (totalCount > 0){
            System.out.println(Thread.currentThread().getName() + "开始消费第:"+totalCount+ "个");
            totalCount--;
            //只要有消费,就释放wait()
            notify();
        }else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Producer extends Thread{ //生产者
    private Product product;

    public Producer(Product product) {
        this.product = product;
    }

    @Override
    public void run() {
        System.out.println(getName()+":开始生产");
        while (true){
            product.creatProduct();
        }

    }
}

class Customer4 extends Thread{//消费者
    private Product product;

    public Customer4(Product product) {
        this.product = product;
    }

    @Override
    public void run() {
        System.out.println(getName() + ":开始消费");
        while (true){
            product.consumProduct();
        }
    }
}