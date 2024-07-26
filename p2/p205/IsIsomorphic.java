package leetcode.p2.p205;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsIsomorphic {
    /**
     * Apr 01, 2024 18:54
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        Set<Character> used = new HashSet<>();
        if (s.length() != t.length()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                if (used.contains(t.charAt(i))) {
                    return false;
                }
                map.put(s.charAt(i), t.charAt(i));
                used.add(t.charAt(i));
            } else {
                if (map.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }
}
