/**
 * @title: pl1111w
 * @description: 给你一个整数 x ，如果 x 是一个回文整数，
 * 返回 true  否则，返回 false 。
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 输入：x = 121
 * 输出：true
 * <p>
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * <p>
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 * @author: Kris
 * @date 2024/4/15 15:04
 */
public class HuiWenNum {

    public static void main(String[] args) {
        int num = 12221;
        System.out.println(HuiWenNum2(num));
    }

    public static boolean HuiWenNum(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int revertedNumber = 0;
        while (x > revertedNumber) {  //不满足条件时 走完一半 前后任意长度组成的值都一样
            revertedNumber = revertedNumber * 10 + x % 10; //从后往前构建数
            x = x / 10;
        }
        return revertedNumber == x || x == revertedNumber / 10;
    }

    public static boolean HuiWenNum2(int x) {
        if (x < 0) return false;
        int div = 1;
        while (x / div >= 10) div *= 10;
        while (x > 0) {
            int left = x / div;
            int right = x % 10;
            if (left != right) return false;
            x = (x % div) / 10; //掐头去尾
            div /= 100;  //掐头去尾位数少2 故除100
        }
        return true;
    }
}
