package leetcode.p1.p126;

import java.util.*;

public class FindLadders {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Map<String, Set<String>> graph = new HashMap<>();
        for (String edge : wordList) {
            graph.put(edge, new HashSet<>());
        }
        for (int i = 0; i < wordList.size() - 1; i++) {
            String edge1 = wordList.get(i);
            for (int j = i + 1; j < wordList.size(); j++) {
                String edge2 = wordList.get(j);
                if (isEdge1(edge1, edge2)) {
                    graph.get(edge1).add(edge2);
                    graph.get(edge2).add(edge1);
                }
            }
        }


        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        Queue<String> queue = new LinkedList<>();

        for (String edge : wordList) {
            if (isEdge1(beginWord, edge)) {
                queue.offer(edge);
            }
        }

        Map<String, Set<String>> prev = new HashMap<>();

        return null;
        // TODO
    }

    public boolean isEdge1(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        boolean first = true;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                if (first) {
                    first = false;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
