package algorithm.stringDemo;

import java.util.HashMap;

/**
 * @title: pl1111w
 * @description:
 * @author: Kris
 * @date 2022/7/29 21:11
 */
public class StrOfStr {

    public static void main(String[] args) {
        int i = strStr("aaaaa", "aaaa");
        System.out.println(i);
    }

    public static int strStr(String haystack, String needle) {

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < haystack.length(); i++) {
            if (!map.containsKey(haystack.charAt(i))) {
                map.put(haystack.charAt(i), i);
            }
        }
        return map.get(needle.charAt(0)) == null ? -1 : map.get(needle.charAt(0));

    }
}
