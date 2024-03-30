package leetcode.p12.p1245;

import java.util.*;

public class TreeDiameter {
    /**
     * Feb 25, 2024 19:34
     * Two DFS
     * Time Complexity: O(node.size)
     * Space Complexity: O(node.size)
     */
    public int[] dfs(Map<Integer, Set<Integer>> graph, int start) {
        int[] result = new int[2];
        Set<Integer> visited = new HashSet<>();
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{start, 0});
        while (!stack.isEmpty()) {
            int[] node = stack.pop();
            visited.add(node[0]);
            if (node[1] > result[1]) {
                result = node;
            }
            for (int nextNode : graph.get(node[0])) {
                if (!visited.contains(nextNode)) {
                    stack.push(new int[]{nextNode, node[1] + 1});
                }
            }
        }
        return result;
    }

    public int treeDiameter(int[][] edges) {
        if (edges.length == 0) {
            return 0;
        }
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            if (!graph.containsKey(edges[i][0])) {
                graph.put(edges[i][0], new HashSet<>());
            }
            if (!graph.containsKey(edges[i][1])) {
                graph.put(edges[i][1], new HashSet<>());
            }
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        int[] result = dfs(graph, 0);
        result = dfs(graph, result[0]);
        return result[1];
    }

    public static void main(String[] args) {
        TreeDiameter t = new TreeDiameter();
        int[][] edges = new int[][]{
                {0, 1},
                {0, 2}
        };

        System.out.println(t.treeDiameter(edges) == 2);
    }
}
