package JavaBase.mainUtil;

/**
 * 抽象类
 */
public class AbstractTest {
    public static void main(String[] args) {
        BankTemplateMethod bankTemplateMethod = new BankTemplateMethod(){

            @Override
            public void transact() {
                System.out.println("我要取款！！！");
            }
        };
        bankTemplateMethod.process();
        BankTemplateMethod bankTemplateMethod2 = new BankTemplateMethod(){

            @Override
            public void transact() {
                System.out.println("我要理财！！！");
            }
        };
        bankTemplateMethod2.process();
    }
}

abstract class BankTemplateMethod{
    //具体方法
    public void takeNumber(){
        System.out.println("取号排队");
    }

    //具体方法抽象，由子类具体实现
    public abstract void transact();

    public void evaluate(){
        System.out.println("反馈评分");
    }

    //模板方法 final修饰不被重写
    public final void process(){
        this.takeNumber();

        this.transact();

        this.evaluate();

    }
}



