package leetcode.p1.p127;

import java.util.*;

public class LadderLength {
    /**
     * BFS
     * 631ms too slow
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<String, HashSet<String>> graph = new HashMap<>();
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


        HashSet<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        int level = 2;

        for (String edge : wordList) {
            if (isEdge1(beginWord, edge)) {
                queue.offer(edge);
            }
        }

        while (!queue.isEmpty()) {
            Queue<String> nextQueue = new LinkedList<>();
            while (!queue.isEmpty()) {
                String edge = queue.poll();
                if (edge.equals(endWord)) {
                    return level;
                }
                for (String s : graph.get(edge)) {
                    if (!visited.contains(s)) {
                        nextQueue.offer(s);
                        visited.add(s);
                    }
                }
            }
            level++;
            queue = nextQueue;
        }
        return 0;
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

    // TODO check the solution
}
