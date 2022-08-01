package algorithm.dynamic;

/**
 * @title: pl1111w
 * @description: 动态规划算法-完全背包
 * @author: Kris
 * @date 2020/12/3 22:10
 */
public class completeKnapsackProblem {

    public static void main(String[] args) {
        int[] w = {1, 3, 4};//物品重量
        int[] val = {700, 2000, 3000};//物品价值
        int container = 5;//背包容量
        int number = val.length;//物品个数

        //创建二维数组
        //v[i][j]表示前i个物品能够装入容量为j的背包中的最大价值
        int[][] v = new int[number + 1][container + 1];

        for (int i = 0; i < v.length; i++) {
            v[i][0] = 0;//背包为容量为0时，价值为0
        }
        for (int i = 0; i < v[0].length; i++) {
            v[0][i] = 0;//物品个数为0时，价值为0
        }

        //开始添加
        for (int i = 1; i < v.length; i++) {
            for (int j = 1; j < v[0].length; j++) {
                for (int k = 0; k * w[i - 1] <= j; k++) {
                    //v[i - 1][j]原来的商品，k:重复个数 ，val[i-1]:当前商品价值，装入当前商品后剩余物品个数：i-i 装入当前商品后背包剩余空间j-w[i-1];
                    v[i][j] = Math.max(v[i - 1][j], v[i - 1][j - w[i - 1] * k] + val[i - 1] * k);
                }

            }
        }
        //打印
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[0].length; j++) {
                System.out.printf(v[i][j] + " ");
            }
            System.out.println();
        }

    }
}

