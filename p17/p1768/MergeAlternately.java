package leetcode.p17.p1768;

public class MergeAlternately {
    /**
     * Feb 11, 2024 00:34
     * Time Complexity: O(n+m)
     * Space Complexity: O(1)
     */
    public String mergeAlternately(String word1, String word2) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < word1.length() && i < word2.length(); i++) {
            s.append(word1.charAt(i));
            s.append(word2.charAt(i));
        }
        if (s.length() / 2 == word1.length()) {
            s.append(word2.substring(s.length() / 2));
        } else {
            s.append(word1.substring(s.length() / 2));
        }
        return s.toString();
    }
}
