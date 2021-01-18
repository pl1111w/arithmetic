package algorithm.dynamic.leecode;

import java.util.Arrays;

/**
 * @title: pl1111w
 * @description: 分糖果：输入分数【1，0，2】 糖果匹配：【2，1，2】
 * 输入分数【1，1，2】 糖果匹配：【1，1，2】
 * 1、每个孩子至少一个糖果
 * 2、相邻的孩子，得分高获得更多的糖果
 * 3、至少需要多少糖果
 * @author: Kris
 * @date 2021/1/18 21:53
 */
public class GreedCandies {

    public static void main(String[] args) {
//        int[] ratings = new int[]{2, 1, 7, 4, 3, 1, 5, 7, 8, 6, 4, 3};
        int[] ratings = new int[]{4, 3, 2, 1, 1, 2, 3, 4};
        int number = candies1(ratings);
        System.out.println();
        System.out.println(number);
    }

    private static int candies(int[] ratings) {

        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);//默认分发一个糖果


        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        int total = candies[ratings.length - 1];//下面的循环没有统计最后一个
        for (int i = ratings.length - 1; i > 0; i--) {
            if (ratings[i] < ratings[i - 1]) {
                candies[i - 1] = Math.max(candies[i] + 1, candies[i - 1]);
            }
            System.out.print(candies[i] + " ");
            total = total + candies[i - 1];
        }
        return total;
    }

    private static int candies1(int[] ratings) {
        int length = ratings.length;
        if (length == 1) {
            return 1;
        }
        int index = 0;//孩子下标
        int total = 0;//糖总数
        while (index < length - 1) {
            int left = 0;
            //递增
            while (index < length - 1 && ratings[index + 1] > ratings[index]) {
                index++;
                left++;
            }
            //递减
            int right = 0;
            while (index < length - 1 && ratings[index + 1] < ratings[index]) {
                index++;
                right++;
            }
            //记录顶点的值，左右两边最大的值+1
            int peekCount = Math.max(left, right) + 1;
            //把数组拆分两个的时候，低估那次分别拆到不同数组中，total不等于0时要减1
            if (total != 0) {
                total--;
            }
            total += (1 + left) * left / 2 + (1 + right) * right / 2 + peekCount;
            while (index < length - 1 && ratings[index] == ratings[index + 1]) {
                index++;
                total++;
            }

        }
        return total;
    }
}
