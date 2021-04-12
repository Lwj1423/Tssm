package JavaBase.mainUtil;

/**
 *
 * 递归求和
 */
public class GetSum {
    public static void main(String[] args) {
        GetSum test = new GetSum();
        int sum1 = test.getSum(100);
        System.out.println(sum1);
    }

    public int getSum(int n){
        if (n == 1){
            return 1;
        }else{
            return n + getSum(n - 1);
        }
    }
}

