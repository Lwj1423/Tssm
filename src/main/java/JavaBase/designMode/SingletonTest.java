package JavaBase.designMode;

/**
 * 单例模式  线程安全
 */
public class SingletonTest {

    public static void main(String[] args) {

        
        //饿汉
        Bank bank1 = Bank.getInstance();
        Bank bank2 = Bank.getInstance();

        System.out.println(bank1 == bank2);

        //懒汉
        Order order1 = Order.getInstance();
        Order order2 = Order.getInstance();

        System.out.println(order1 == order2);
    }

}

/**
 * 饿汉式
 */
class Bank{

    //私有化类的构造器
    private Bank(){

    }

    //内部创建类的对象
    //此对象必须声明为静态的
    private static Bank instance = new Bank();

    //创建公共静态方法
    public static Bank getInstance(){
        return instance;
    }
}

/**
 * 懒汉式
 */
class Order{

    //私有化类的构造器
    private Order(){

    }

    private static Order instance = null;

    //创建公共静态方法
    public static Order getInstance() {
        //考虑线程安全  方式一：效率稍差
       /* synchronized (Order.class) {
            if (instance == null) {
                instance = new Order();
            }
            return instance;
        }
*/
        //方式二  效率更高
        if (instance == null) {
            synchronized (Order.class) {
                if (instance == null) {
                    instance = new Order();
                }

            }
        }
        return instance;
    }
}
