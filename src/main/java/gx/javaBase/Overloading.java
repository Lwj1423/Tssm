package gx.javaBase;

public class Overloading {
    public static void main(String[] args) {
        Demo laoWang = new Demo();
        laoWang.read();
        laoWang.read("红楼梦");
    }
}

     class Demo{

        public void read() {
            System.out.println("测试重载的父类方法");
        }

        public void read(String book) {
            System.out.println("这是子类的" + book + "书");
        }
    }
