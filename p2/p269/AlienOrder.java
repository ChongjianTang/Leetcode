package leetcode.p2.p269;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AlienOrder {
    /**
     * My approach
     * Two HashMap
     * Topological sort
     */
    public static String alienOrder(String[] words) {
        Map<Character, Set<Character>> inGraph = new HashMap<>();
        Map<Character, Set<Character>> outGraph = new HashMap<>();
        for (String word : words) {
            for (int j = 0; j < word.length(); j++) {
                if (!inGraph.containsKey(word.charAt(j))) {
                    inGraph.put(word.charAt(j), new HashSet<>());
                    outGraph.put(word.charAt(j), new HashSet<>());
                }
            }
        }
        for (int i = 0; i < words.length; i++) {
            if (i != words.length - 1) {
                if (!compareWords(words[i], words[i + 1], inGraph, outGraph)) {
                    return "";
                }
            }
        }
        Set<Character> visited = new HashSet<>();
        StringBuilder result = new StringBuilder();
        while (visited.size() < inGraph.size()) {
            boolean noAnswer = true;
            for (char c : inGraph.keySet()) {
                if (inGraph.get(c).isEmpty() && !visited.contains(c)) {
                    result.append(c);
                    for (char nextNode : outGraph.get(c)) {
                        inGraph.get(nextNode).remove(c);
                    }
                    visited.add(c);
                    noAnswer = false;
                }
            }
            if (noAnswer) {
                return "";
            }
        }
        return result.toString();
    }

    public static boolean compareWords(String word1, String word2, Map<Character, Set<Character>> inGraph, Map<Character, Set<Character>> outGraph) {
        int i = 0;
        while (i < word1.length() && i < word2.length()) {
            if (word1.charAt(i) != word2.charAt(i)) {
                inGraph.get(word2.charAt(i)).add(word1.charAt(i));
                outGraph.get(word1.charAt(i)).add(word2.charAt(i));
                return true;
            }
            i++;
        }
        return word1.length() <= word2.length();
    }

    public static void main(String[] args) {
        String[] words = new String[]{"wrt", "wrf", "er", "ett", "rftt"};
        System.out.println(alienOrder(words));
        words = new String[]{"z", "x", "z"};
        System.out.println(alienOrder(words));
    }
}
