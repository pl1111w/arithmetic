package algorithm.kmp;

/**
 * @title: pl1111w
 * @description: 字符串暴力匹配
 * @author: Kris
 * @date 2020/12/4 20:42
 */
public class ViolenceMatch {

    public static void main(String[] args) {

        //测试暴力匹配算法
        String str1 = "尚硅谷 尚硅谷你尚硅 尚硅谷你尚硅谷你尚硅你好";
        String str2 = "尚硅谷你尚硅你";

        int index = violenceMatch(str1, str2);
        System.out.println("index:" + index);
    }

    private static int violenceMatch(String str1, String str2) {

        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();

        int lenth1 = s1.length;
        int lenth2 = s2.length;

        int i = 0;
        int j = 0;
        while (i < lenth1 && j < lenth2) {
            if (s1[i] == s2[j]) {
                i++;
                j++;
            } else {
                i = i - (j - 1);
                j = 0;
            }
        }
        if (j == lenth2) {
            return i - j ;
        } else {
            return -1;
        }
    }
}
