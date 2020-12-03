package algorithm.dynamic;

/**
 * @title: pl1111w
 * @description: 0-1背包 <-> 动态规划算法
 * @author: Kris
 * @date 2020/12/3 20:47
 */
public class KnapsackProblem {

    public static void main(String[] args) {
        int[] w = {1, 3, 4};//物品重量
        int[] val = {1500, 2000, 3000};//物品价值
        int container = 4;//背包容量
        int number = val.length;//物品个数

        int[][] path = new int[number + 1][container + 1];

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
                if (w[i - 1] > j) {
                    v[i][j] = v[i - 1][j];
                } else {
                    //v[i - 1][j]原来的商品，val[i-1]:当前商品价值，装入当前商品后剩余物品个数：i-i 装入当前商品后背包剩余空间j-w[i-1];
                    //v[i][j] = Math.max(v[i - 1][j], val[i - 1] + v[i - 1][j - w[i - 1]]);
                    if (v[i - 1][j] > val[i - 1] + v[i - 1][j - w[i - 1]]) {
                        v[i][j] = v[i - 1][j];
                    } else {
                        v[i][j] = val[i - 1] + v[i - 1][j - w[i - 1]];
                        path[i][j] = 1;
                    }
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
        int i = path.length - 1;
        int j = path[0].length - 1;
        while (i > 0 && j > 0) {
            if (path[i][j] == 1) {
                System.out.printf("第%d个商品放入背包\n", i);
                j = j - w[i - 1];
            }
            i--;
        }
    }
}
