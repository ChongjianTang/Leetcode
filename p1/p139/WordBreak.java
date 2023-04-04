package leetcode.p1.p139;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    /**
     * 09/21/2022 01:01
     * DP + Trie
     */
    public boolean wordBreak1(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        TrieNode root = new TrieNode();
        for (String word : wordDict) {
            TrieNode temp = root;
            for (int j = 0; j < word.length(); j++) {
                if (temp.children[word.charAt(j) - 'a'] == null) {
                    temp.children[word.charAt(j) - 'a'] = new TrieNode();
                }
                temp = temp.children[word.charAt(j) - 'a'];
                if (j == word.length() - 1) {
                    temp.isAWord = true;
                }
            }
        }
        dp[0] = true;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j]) {
                    TrieNode temp = root;
                    for (int k = j; k < i; k++) {
                        System.out.println(s.charAt(k));
                        if (temp == null) {
                            break;
                        }
                        temp = temp.children[s.charAt(k) - 'a'];
                    }
                    if (temp != null && temp.isAWord) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[s.length()];
    }

    class TrieNode {
        Boolean isAWord;
        TrieNode[] children;

        public TrieNode() {
            isAWord = false;
            children = new TrieNode[26];
        }
    }

    /**
     * 09/21/2022 01:06
     * DP
     * Time complexity: O(n^3)
     * Space complexity: O(n)
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
