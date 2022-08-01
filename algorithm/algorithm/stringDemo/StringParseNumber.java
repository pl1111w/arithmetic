package algorithm.stringDemo;

/**
 * @title: pl1111w
 * @description:
 * @author: Kris
 * @date 2022/7/29 10:50
 */
public class StringParseNumber {

    public static void main(String[] args) {
        StringParseNumber stringParseNumber = new StringParseNumber();
        int i = stringParseNumber.myAtoi("18ab -+cdef");
        System.out.println(i);
    }

    public int myAtoi1(String s) {
        int number = 0;
        int sign = 1;
        int index = 0;
        String str = s.trim();
        char[] chars = str.toCharArray();
        int length = chars.length;
        if (length == 0) return number;
        if (chars[index] == '-' || chars[index] == '+') {
            if (chars[index] == '-') {
                sign = -1;
            }
            index++;
        }
        int result = 0;
        int temp = 0;
        while (index < length) {
            int num = chars[index] - '0';
            if (num > 9 || num < 0) {
                break;
            }
            temp = result;
            result = result * 10 + num;
            if (result / 10 != temp) {
                if (sign > 0) {
                    return Integer.MAX_VALUE;
                } else {
                    return Integer.MIN_VALUE;
                }
            }
            index++;
        }
        return result * sign;
    }

    public int myAtoi(String s) {
        int number = 0;
        String trim = s.trim();
        int length = trim.length();
        if (length == 0) return number;
        char[] chars = trim.toCharArray();
        int index = 0;
        int sign = 1;

        if (chars[index] == '+' || chars[index] == '-') {
            if (chars[index] == '-') {
                sign = -1;
            }
            index++;
        }
        while (index < length) {
            int num = chars[index] - '0';
            if (num > 9 || num < 0) {
                break;
            }
            int temp = number;
            number = num + number * 10;
            if (number / 10 != temp) {
                if (sign > 0) {
                    return Integer.MAX_VALUE;
                } else {
                    return Integer.MIN_VALUE;
                }
            }
            index++;
        }

        return number * sign;
    }

}
