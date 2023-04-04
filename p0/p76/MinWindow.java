package leetcode.p0.p76;

import java.util.HashMap;
import java.util.Map;

public class MinWindow {
    /**
     * My approach
     * Sliding window
     * Time complexity: O(m+n) 2m+n
     * Space complexity: O(n) n is the length of t
     */
    public static String minWindow(String s, String t) {
        int left = 0;
        int right = 0;
        int count = 0;
        String min = s + " ";
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            if (!map.containsKey(t.charAt(i))) {
                map.put(t.charAt(i), 1);
            } else {
                map.put(t.charAt(i), map.get(t.charAt(i)) + 1);
            }
        }
        while (right < s.length()) {
            if (map.containsKey(s.charAt(right))) {
                if (count == 0) {
                    left = right;
                }
                int temp = map.get(s.charAt(right));
                if (temp > 0) {
                    count++;
                }
                map.put(s.charAt(right), temp - 1);
                if (count == t.length()) {
                    while (!map.containsKey(s.charAt(left)) || map.get(s.charAt(left)) < 0) {
                        if (map.containsKey(s.charAt(left))) {
                            map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                        }
                        left++;
                    }
                    if (min.length() > right - left + 1) {
                        min = s.substring(left, right + 1);
                    }
                }
            }
            right++;
        }
        if (min.length() > s.length()) {
            return "";
        }
        return min;
    }

    // TODO there is a optimized approach in solution part

    public static void main(String[] args) {
        System.out.println(minWindow("baAaABabBba", "AbbB"));
    }
}
