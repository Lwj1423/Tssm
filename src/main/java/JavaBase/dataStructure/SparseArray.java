package JavaBase.dataStructure;

public class SparseArray {


    /**
     * 五子棋模拟稀松数组
     * @param args
     */
    public static void main(String[] args) {
        //一、创建二维数组
        //0:表示没有棋子, 1表示黑子,2表示 蓝子
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        for (int[] row: chessArr1) {
            for (int data: row) {
                //格式化输出
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        // 二、将二维数组 转  稀疏数组的思路
        // 1.先遍历二维数组, 得到非0 数据的个数
        int sum = 0;
        for (int i= 0; i<11; i++){
            for (int j = 0; j< 11; j++){
                if (chessArr1[i][j] != 0 ){
                    sum++;
                }
            }
        }
        // 2.创建对应的稀疏数组
        int[][] sparseArr = new int[sum+1][3];
        //给稀疏数组赋值
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;
        //遍历二维数组,将非0的值存放到sparseArr中
        int count = 0;  //记录第几个非0数据
        for (int i= 0; i<11; i++){
            for (int j = 0; j< 11; j++){
                if (chessArr1[i][j] != 0 ){
                    //稀疏数组函数递增
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }
        //3.输出稀疏数组的形式
        System.out.println("得到的稀疏数组~~~~~~~~~");
        for (int i = 0; i < sparseArr.length; i++){
            System.out.printf("%d\t%d\t%d\t\n",sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);
        }
        System.out.println();

        //三、将稀疏数组  转 二维数组
        //1.先读取稀疏数组第一行数据，来创建二维数组
        int[][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];

        //2.将稀疏数组行元素 赋值给对应的二维数组
        for (int i = 1; i < sparseArr.length; i++){
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        //3. 输出新二维数组
        System.out.println("新二维数组~~~~~~~~~~");
        for (int[] row: chessArr2) {
            for (int data: row) {
                //格式化输出
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }


        }
    }

