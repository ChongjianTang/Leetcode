package leetcode.p1.p159;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstringTwoDistinct {
    /**
     * Apr 01, 2024 00:07
     * From problem 340
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int left = -1;
        Map<Character, Integer> frequencyMap = new HashMap<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!frequencyMap.containsKey(s.charAt(i))) {
                frequencyMap.put(s.charAt(i), 1);
            } else {
                frequencyMap.put(s.charAt(i), frequencyMap.get(s.charAt(i)) + 1);
            }
            while (frequencyMap.size() > 2 && left < s.length() - 1) {
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
}
