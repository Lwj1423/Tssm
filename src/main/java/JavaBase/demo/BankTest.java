package JavaBase.demo;

/**
 * 银行账户取钱 项目一
 */
public class BankTest {
    public static void main(String[] args) {

        Bank bank = new Bank();

        bank.addCustomer("张三");

        bank.getCustomer(0).setAccount(new Account(100000));

        bank.getCustomer(0).getAccount().withdraw(200);

        double balance = bank.getCustomer(0).getAccount().getBalance();
        System.out.println("客户"+bank.getCustomer(0).getName() +"账户余额:"+balance);

        bank.addCustomer("李四");
        System.out.println("客户个数:" + bank.getNumbersOfCustomers());
    }


}


/**
 * 银行
 */
class Bank{
    private Customer[] customers; //存放多个客户
    private int numbersOfCustomers;//客户个数

    public Bank() {
        //初始化时,创建客户数组
        customers = new Customer[10];
    }

    //添加客户
    public void addCustomer(String name){
        Customer cust = new Customer(name);
        customers[numbersOfCustomers++] = cust;
    }

    //获取客户数
    public int getNumbersOfCustomers(){
        return numbersOfCustomers;
    }

    //获取指定位置上的客户
    public Customer getCustomer(int index){
        if (index >= 0 && index < customers.length){
            return customers[index];
        }
        return null;
    }
}

/**
 * 客户
 */
class Customer{
    private String name;
    private Account account;

    public Customer(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public Account getAccount() {
        return account;
    }
}

/**
 * 账户
 */
class Account{

    private double balance;

    public Account(double init_balance){
        this.balance = init_balance;
    }

    public double getBalance(){
        return balance;
    }

    //存钱操作
    public void deposit(double amt){
        if (amt > 0){
            balance += amt;
            System.out.println("存钱成功");
        }
    }

    //取钱操作
    public void withdraw(double amt){
        if (balance >= amt){
            balance -= amt;
            System.out.println("取钱成功");
        }else{
            System.out.println("余额不足");
        }

    }
}