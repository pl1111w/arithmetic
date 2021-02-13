package algorithm.stringDemo;

import java.util.ArrayList;
import java.util.List;

/**
 * @title: pl1111w
 * @description: 分割回文字符串
 * @author: Kris
 * @date 2021/2/10 20:24
 */
public class StringsPartition {

    public static void main(String[] args) {
        StringsPartition stringsPartition = new StringsPartition();
        List<List<String>> list = stringsPartition.partition("ababa");
        System.out.println(list);
    }

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> partition = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }
        helper(s, partition, 0, result);
        return result;
    }

    //回溯
    private void helper(String s, List<String> partition,
                        int startIndex, List<List<String>> result) {
        if (startIndex == s.length()) {
            result.add(new ArrayList<>(partition));
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            String sb = s.substring(startIndex, i + 1);
            if (!isPalindrome(sb)) {
                continue;
            }
            partition.add(sb);
            helper(s, partition, i + 1, result);
            partition.remove(partition.size() - 1);//回溯
        }
    }

    //isPalindrome
    private boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    //分治法
    private List<List<String>> partitionHelper(String s, int start) {
        //递归出口，空字符串
        if (start == s.length()) {
            List<String> list = new ArrayList<>();
            List<List<String>> ans = new ArrayList<>();
            ans.add(list);
            return ans;
        }
        List<List<String>> ans = new ArrayList<>();
        for (int i = start; i < s.length(); i++) {
            //当前切割后是回文串才考虑
            if (isPalindrome(s.substring(start, i + 1))) {
                String left = s.substring(start, i + 1);
                //遍历后边字符串的所有结果，将当前的字符串加到头部
                for (List<String> l : partitionHelper(s, i + 1)) {
                    l.add(0, left);
                    ans.add(l);
                }
            }

        }
        return ans;
    }

    //动态规划算法
    public List<List<String>> partitionPlus(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int length = s.length();
        for (int len = 1; len <= length; len++) {
            for (int i = 0; i <= s.length() - len; i++) {
                int j = i + len - 1;
                dp[i][j] = s.charAt(i) == s.charAt(j) && (len < 3 || dp[i + 1][j - 1]);
            }
        }
        return partitionHelper(s, 0, dp);
    }

    private List<List<String>> partitionHelper(String s, int start, boolean[][] dp) {
        if (start == s.length()) {
            List<String> list = new ArrayList<>();
            List<List<String>> ans = new ArrayList<>();
            ans.add(list);
            return ans;
        }
        List<List<String>> ans = new ArrayList<>();
        for (int i = start; i < s.length(); i++) {
            if (dp[start][i]) {
                String left = s.substring(start, i + 1);
                for (List<String> l : partitionHelper(s, i + 1, dp)) {
                    l.add(0, left);
                    ans.add(l);
                }
            }

        }
        return ans;
    }

}
