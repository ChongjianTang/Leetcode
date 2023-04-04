package leetcode.p2.p242;

import java.util.HashMap;
import java.util.Map;

public class IsAnagram {
    /**
     * 08/30/2022 20:04
     * HashMap
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1);
            } else {
                int freq = map.get(s.charAt(i));
                map.put(s.charAt(i), freq + 1);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            if (map.containsKey(t.charAt(i))) {
                int freq = map.get(t.charAt(i));
                if (freq == 1) {
                    map.remove(t.charAt(i));
                } else {
                    map.put(t.charAt(i), freq - 1);
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
