package JavaBase.mainUtil;


/**
 *
 * 数组常用方法
 */
public class ArrayUtil {

    //求数组最大值
    public int getMax(int[] arr){
        int maxValue = arr[0];
        for (int i = 1;i < arr.length; i++){
            if (maxValue < arr[i]){
                maxValue = arr[i];
            }
        }
        return maxValue;
    }

    //求数组的最小值
    public int getMinValue(int[] arr){
        int minValue = arr[0];
        for (int i = 0 ; i < arr.length; i++){
            if (minValue > arr[i]){
                minValue = arr[i];
            }
        }
        return minValue;
    }

    //求数组的总和
    public int getSum(int[] arr){
        int sum = 0;
        for (int i=0; i < arr.length;i++){
            sum += arr[i];
        }
        return sum;
    }

    //求数组的平均值
    public int getAvg(int[] arr){
        return getSum(arr) / arr.length;
    }

    //反转数组
    public void reverse(int[] arr){
        for (int i = 0; i <arr.length; i ++){
            int temp = arr[i];
            arr[i] = arr[arr.length - 1];
            arr[arr.length - 1] = arr[i];
        }
    }

    //复制数组
    public int[] copy(int[] arr){
        int[] arr1 = new int[arr.length];
        for (int i = 0; i <arr1.length; i ++){
            arr1[i] = arr[i];
        }
        return arr1;
    }

    //查找指定元素
    public int getIndex(int[] arr, int dest){
        //线性查找
        for (int i = 0 ; i < arr.length; i ++){
            if (dest == arr[i]){
                return i;
            }
        }
        return -1;//表示没找到
    }

}
