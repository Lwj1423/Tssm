package gx.dataStructure;

/**
 * 数组模拟环形队列
 */
public class CircleArray{
    private int maxSize;  //表示数组最大容量
    private int front;  //指向队列的第一个元素  默认为0
    private int rear;  //指向队列最后一个元素的后一位
    private int[] arr;  //存放数据,模拟队列

    //构造函数
    public CircleArray(int arrMaxSize){
        maxSize = arrMaxSize;
        arr = new int[maxSize];
    }

    //判断队列是否满
    public boolean isFull(){
        return (rear +1)%maxSize == front;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return rear == front;
    }

    //添加数据到队列
    public void addQueue(int n){
        //判断队列是否满
        if (isFull()){
            System.out.println("队列满,不能加入数据~~");
            return;
        }
        //直接加入数据
        arr[rear] = n;
        //将rear向后移动;   取模是为了防止数据越界
        rear = (rear +1)%maxSize;
    }


    // 获取队列中的数据,出队列
    public int getQueue(){
        //判断队列是否为空
        if (isEmpty()){
            //通过抛出异常提醒
            throw new RuntimeException("队列空,不能取数据");
        }

        //这里需要分析  front是指向队列中的第一个元素
        // 1.将数据存放在临时变量汇总
        //2.将front的值向后移
        //3.返回临时变量的值
        int temp = arr[front];
        front = (front +1)%maxSize;
        return temp;
    }

    //显示队列的所有数据
    public void showQueue(){
        //遍历
        if (isEmpty()){
            System.out.println("队列空的,没有数据~~");
            return;
        }

        //思路: 从front开始遍历,  遍历多少个元素
        for (int i = front; i < front + size();i++){
            System.out.printf("arr[%d]=%d\n",i%maxSize,arr[i%maxSize]);
        }


    }
    //计算环形队列的个数
    private int size() {
        return (rear + maxSize - front)%maxSize;
    }


    //显示头数据,并不取数
    public int  headQueue(){
        //判断
        if (isEmpty()){
            throw new RuntimeException("队列是空的,没有数据");
        }
        return arr[front];
    }
}
