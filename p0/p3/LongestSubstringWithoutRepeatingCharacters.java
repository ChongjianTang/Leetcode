package leetcode.p0.p3;

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {
    //    public int lengthOfLongestSubstring(String s) {
//        int result = 1, longest = 0;
//        Set<Character> set = new HashSet<>();
//        for (int i = 0; i < s.length(); i++) {
//            set.add(s.charAt(i));
//            for (int j = i + 1; j < s.length(); j++) {
//                if (!set.contains(s.charAt(j))) {
//                    result++;
//                    set.add(s.charAt(j));
//                } else {
//                    break;
//                }
//            }
//            if (result > longest) {
//                longest = result;
//            }
//            result = 1;
//            set.clear();
//        }
//        return longest;
//    }
//    public int lengthOfLongestSubstring(String s) {
//        for (int i = 0; i < s.length(); i++) {
//
//        }
//    }


    /**
     * My approach
     * Time complexity: O(n^2)
     * Space complexity: O(n)
     */
    public static int lengthOfLongestSubstring1(String s) {
        int result = 0, longest = 0;
        if (s.equals("")) {
            return 0;
        }
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (!queue.contains(s.charAt(i))) {
                queue.add(s.charAt(i));
                result++;
                if (result > longest) {
                    longest = result;
                }
            } else {
                char c = queue.poll();
                queue.add(s.charAt(i));
                while (c != s.charAt(i)) {
                    c = queue.poll();
                    result--;
                }
            }
        }
        return longest;
    }

    /**
     * Sliding window + HashMap
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 1;
        int result = 1;
        map.put(s.charAt(0), 0);
        while (right < s.length()) {
            if (map.containsKey(s.charAt(right))) {
                left = Math.max(map.get(s.charAt(right)) + 1, left);
            }
            result = Math.max(result, right - left + 1);
            map.put(s.charAt(right), right);
            right++;
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("au"));
    }
}
