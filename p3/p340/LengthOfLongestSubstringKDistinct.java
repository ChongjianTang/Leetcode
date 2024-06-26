package leetcode.p3.p340;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstringKDistinct {
    /**
     * Mar 30, 2024 02:25
     * Sliding window
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int left = -1;
        Map<Character, Integer> frequencyMap = new HashMap<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!frequencyMap.containsKey(s.charAt(i))) {
                frequencyMap.put(s.charAt(i), 1);
            } else {
                frequencyMap.put(s.charAt(i), frequencyMap.get(s.charAt(i)) + 1);
            }
            while (frequencyMap.size() > k && left < s.length() - 1) {
                left++;
                if (frequencyMap.get(s.charAt(left)) == 1) {
                    frequencyMap.remove(s.charAt(left));
                } else {
                    frequencyMap.put(s.charAt(left), frequencyMap.get(s.charAt(left)) - 1);
                }
            }
            max = Math.max(max, i - left);
        }
        return max;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstringKDistinct l = new LengthOfLongestSubstringKDistinct();
        String s;
        int k;
        s = "ccaabbb";
        k = 2;
        System.out.println(l.lengthOfLongestSubstringKDistinct(s, k) == 5);
    }
}
