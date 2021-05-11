package JavaBase.designMode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理 举例
 * 
 */

//定义规范
interface Human{

    String getBelief();

    void eat(String food);
}

//定义被代理类
class SuperMan implements Human{

    @Override
    public String getBelief() {
        return "I beleve I can fly!";
    }

    @Override
    public void eat(String food) {
        System.out.println(food);
    }
}

//动态创建代理类
class ProxyFactory{
        public static Object getProxyInstance(Object obj){//obj:被代理对象
            MyInvocationHandler handler = new MyInvocationHandler();

            handler.bind(obj);

            return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),handler);
        }
}

class MyInvocationHandler implements InvocationHandler{

    private Object obj;

    public void bind(Object obj){
        this.obj = obj;
    }

    //当通过代理类对象,调用方法时,自动调用invoke方法
    //将被代理类要执行的方法 的功能声明在invoke中
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(obj,args);
    }
}

//模拟AOP
class HumanUtil{

    public void method1(){
        System.out.println("====方法一=====");
    }

    public void method2(){
        System.out.println("====方法二=====");
    }

}


public class ProxyTest {
    public static void main(String[] args) {

        //增加方法
        new HumanUtil().method1();

        SuperMan superMan = new SuperMan();
        Human proxyInstance  = (Human) ProxyFactory.getProxyInstance(superMan);

        proxyInstance.getBelief();
        proxyInstance.eat("测测测");

        new HumanUtil().method2();
    }




}
