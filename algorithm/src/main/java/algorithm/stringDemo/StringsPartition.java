package algorithm.stringDemo;

import java.util.ArrayList;
import java.util.List;

/**
 * @title: pl1111w
 * @description:
 * @author: Kris
 * @date 2021/2/10 20:24
 */
public class StringsPartition {

    public static void main(String[] args) {
       StringsPartition stringsPartition = new StringsPartition();
        List<List<String>> list= stringsPartition.partition("ababa");
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
    //helper
    private void helper (String s, List<String> partition,
                         int startIndex, List<List<String>> result) {
        if (startIndex == s.length()) {
            result.add(new ArrayList<String>(partition));
            return ;
        }

        for (int i = startIndex; i < s.length(); i++) {
            String sb = s.substring(startIndex, i + 1);
            if (!isPalindrome(sb)) {
                continue;
            }
            partition.add(sb);
            helper(s, partition, i + 1, result);
            partition.remove(partition.size() - 1);
        }
    }
    //isPalindrome
    private boolean isPalindrome (String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}