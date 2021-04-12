package JavaBase.mainUtil;

/**
 * 冒泡排序
 */
public class Dubule_02 {
    public static void main(String[] args) {
        int[] arr = new int[]{22,3,4,-2,55,5,7,8};
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j<arr.length - 1 -i;j++){
                if (arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }

        }
        System.out.println("最终得出的数组为：");
        for (int k =0 ; k < arr.length;k++){
            System.out.print(arr[k]+" ");
        }
    }
}
