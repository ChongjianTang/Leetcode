package leetcode.p2.p291;

import java.util.HashMap;
import java.util.Map;

public class WordPatternMatch {
    /**
     * My approach
     * Recursion + HashMap
     * Time complexity: O(nm)
     * Space complexity: O(n) n is the length of pattern
     */
    public static boolean wordPatternMatch(String pattern, String s) {
        return backtracking1(pattern, 0, s, 0, new HashMap<>());
    }

    public static boolean backtracking1(String pattern, int index1, String s, int index2, Map<Character, String> map) {
        if (index1 == pattern.length() && index2 == s.length()) {
            return true;
        }
        if (index1 < pattern.length() && index2 < s.length()) {
            if (map.containsKey(pattern.charAt(index1))) {
                String str = map.get(pattern.charAt(index1));
                if (index2 + str.length() > s.length() || !str.equals(s.substring(index2, index2 + str.length()))) {
                    return false;
                } else {
                    return backtracking1(pattern, index1 + 1, s, index2 + str.length(), map);
                }
            } else {
                for (int i = index2 + 1; i < s.length() + 1; i++) {
                    String str = s.substring(index2, i);
                    if (!map.containsValue(str)) {
                        map.put(pattern.charAt(index1), str);
                        if (backtracking1(pattern, index1 + 1, s, i, map)) {
                            return true;
                        }
                        map.remove(pattern.charAt(index1));
                    }
                }
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(wordPatternMatch("aabb", "xyzabcxzyabc"));
    }
}
