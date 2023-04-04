package leetcode.p4.p472;

import java.util.ArrayList;
import java.util.List;

public class FindAllConcatenatedWordsInADict {
    /**
     * DFS
     * TLE
     */
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (dfs1(words, i, words[i])) {
                result.add(words[i]);
            }
        }
        return result;
    }

    static boolean dfs1(String[] words, int skip, String word) {
        if (word.length() == 0) {
            return true;
        }
        for (int i = 0; i < words.length; i++) {
            if (i != skip) {
                if (words[i].length() <= word.length() && words[i].equals(word.substring(0, words[i].length()))) {
                    if (dfs1(words, skip, word.substring(words[i].length()))) {
                        return true;
                    }
                }
            }
        }
        return false;
        // TODO bfs homework and I don't know how to do this
    }
}
