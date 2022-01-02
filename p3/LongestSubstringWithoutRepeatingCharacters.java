package leetcode.p3;

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


    public static int lengthOfLongestSubstring(String s) {
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

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
