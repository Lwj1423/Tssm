package JavaBase.designMode;

/**
 * 代理模式: 静态代理
 */
public class ProxyTest {

    public static void main(String[] args) {
        StarProxy starProxy = new StarProxy(new StarImpl());
        starProxy.confer();
        starProxy.sing();
        starProxy.signContract();
    }
}

//定义规范
interface Star{
    void confer(); //面谈

    void sing();//唱歌

    void signContract(); //签合同
}

//被代理类实现规范
class StarImpl implements Star{

    @Override
    public void confer() {

    }

    @Override
    public void sing() {
        System.out.println("鹿晗只负责唱歌！！！！！");
    }

    @Override
    public void signContract() {

    }
}

//代理类实现规范
class StarProxy implements Star{

    //被代理类
    private StarImpl star;

    public StarProxy(StarImpl star) {
        this.star = star;
    }

    @Override
    public void confer() {
        System.out.println("代理会面谈");
    }

    @Override
    public void sing() {
        star.sing();
    }

    @Override
    public void signContract() {
        System.out.println("代理会签合同");
    }
}