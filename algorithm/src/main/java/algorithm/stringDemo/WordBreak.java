package algorithm.stringDemo;

import java.util.*;

/**
 * @title: pl1111w
 * @description: 单词拆分
 * @author: Kris
 * @date 2021/2/13 9:59
 */
public class WordBreak {

    public static void main(String[] args) {
        String s = "cars";
        String[] wordDict = new String[]{"car", "ca", "rs"};
        WordBreak wordBreak = new WordBreak();
        boolean result = wordBreak.wordBreak(s, Arrays.asList(wordDict));
        System.out.println(result);
    }

    public boolean wordBreak(String s, List<String> wordDict) {

        return word_Break(s, new HashSet(wordDict), 0);
    }

    private boolean word_Break(String s, HashSet hashSet, int start) {
        if (start == s.length()) {
            return true;
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (hashSet.contains(s.substring(start, end)) && word_Break(s, hashSet, end)) {
                return true;
            }
        }
        return false;
    }
    //记忆回溯
    public boolean wordBreak2(String s, List<String> wordDict) {
        return word_Break(s, new HashSet(wordDict), 0, new Boolean[s.length()]);
    }
    public boolean word_Break(String s, Set<String> wordDict, int start, Boolean[] memo) {
        if (start == s.length()) {
            return true;
        }
        if (memo[start] != null) {
            return memo[start];
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && word_Break(s, wordDict, end, memo)) {
                return memo[start] = true;
            }
        }
        return memo[start] = false;
    }
    //动态规划算法
    public boolean wordBreak3(String s, List<String> wordDict) {
        Set<String> wordDictSet=new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
