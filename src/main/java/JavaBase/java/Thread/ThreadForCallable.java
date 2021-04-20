package JavaBase.java.Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 创建线程  方式三: 实现Callable接口
 */

//1.创建一个实现Callable的实现类
public class ThreadForCallable implements Callable<Integer> {

    //2.实现call方法,将执行操作放在代码块中
    @Override
    public Integer call() throws Exception {
        int count = 0;
        for (int i = 0; i < 100; i++){
            if (i%2 == 0){
                System.out.println(i);
            }
            count += i;
        }
        return count;
    }
}

class test05{
    public static void main(String[] args) {
        //3.创建callable接口实现类的对象
        ThreadForCallable t3 = new ThreadForCallable();
        //4.创建FutureTask 并传参
        FutureTask<Integer> futureTask = new FutureTask<>(t3);
        //5.启动线程
        new Thread(futureTask).start();

        try {
            //6.获取Callable中call方法的返回值(可选)
            Integer count = futureTask.get();
            System.out.println("总数:" + count );
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
