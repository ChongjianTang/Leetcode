package leetcode.p2.p290;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordPattern {
    /**
     * One HashMap one HashSet
     * Time complexity: O(n), n represents the number of words in s.
     * Space complexity: O(m), m represents the number of unique words in s.
     */
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (words.length != pattern.length()) {
            return false;
        }
        Map<String, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < pattern.length(); i++) {
            if (!map.containsKey(words[i])) {
                map.put(words[i], pattern.charAt(i));
            } else {
                if (map.get(words[i]) != pattern.charAt(i)) {
                    return false;
                }
            }
            set.add(pattern.charAt(i));
            if (map.size() != set.size()) {
                return false;
            }
        }
        return true;
    }
}
