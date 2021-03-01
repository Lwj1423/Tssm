package gx.javaBase;

/**
 * 重写
 */
class Overriding {


    public static void main(String[] args) {
        LaoWang laoWang = new XiaoWang();
        laoWang.write();
    }
}
    /**
     * 父类
     */
    class LaoWang{
        public void write(){
            System.out.println("老王的方法");
        }
    }

/**
 * 子类
 */
class XiaoWang extends LaoWang{
        @Override
        public void write() {
            System.out.println("这是小王的方法");
        }
    }





