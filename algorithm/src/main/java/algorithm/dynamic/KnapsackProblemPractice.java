package algorithm.dynamic;

/**
 * @title: pl1111w
 * @description:0-1背包
 * @author: Kris
 * @date 2020/12/24 20:35
 */
public class KnapsackProblemPractice {

    public static void main(String[] args) {

        int[] w = {1, 3, 4};//物品重量
        int[] val = {1500, 2000, 3000};//物品价值
        int container = 4;//背包容量
        int number = val.length;//物品个数

        int[][] v = new int[number + 1][container + 1];
        for (int i = 0; i < number + 1; i++) {
            v[i][0] = 0;
        }
        for (int i = 0; i < container + 1; i++) {
            v[0][i] = 0;
        }

        int[][] path = new int[number + 1][container + 1];
        for (int i = 1; i < v.length; i++) {
            for (int j = 1; j < v[0].length; j++) {
                if (w[i - 1] > j) {
                    v[i][j] = v[i - 1][j];
                } else {
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
