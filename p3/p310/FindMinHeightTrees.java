package leetcode.p3.p310;

import java.util.*;

public class FindMinHeightTrees {
    /**
     * Topological Sorting
     * TLE - 68-71
     */
    public List<Integer> findMinHeightTrees1(int n, int[][] edges) {
        int[][] graph = new int[n][n];
        int[] degree = new int[n];
        for (int[] edge : edges) {
            graph[edge[0]][edge[1]] = 1;
            graph[edge[1]][edge[0]] = 1;
            degree[edge[0]]++;
            degree[edge[1]]++;
        }
        int count = 0;
        while (n - count > 2) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < degree.length; i++) {
                if (degree[i] == 1) {
                    temp.add(i);
                    count++;
                }
            }
            for (int node : temp) {
                for (int i = 0; i < n; i++) {
                    if (graph[node][i] == 1) {
                        graph[node][i] = 0;
                        graph[i][node] = 0;
                        degree[node] = -1;
                        degree[i]--;
                        break;
                    }
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] != -1) {
                result.add(i);
            }
        }
        return result;
    }

    /**
     * Topological Sorting
     */
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        Set<Integer> leaves = new HashSet<>();
        for (int node : graph.keySet()) {
            if (graph.get(node).size() == 1) {
                leaves.add(node);
            }
        }
        while (n > 2) {
            n -= leaves.size();
            Set<Integer> newLeaves = new HashSet<>();
            for (Integer node : leaves) {
                Integer neighbor = graph.get(node).get(0);
                if (graph.containsKey(neighbor)) {
                    graph.get(neighbor).remove(node);
                }
                graph.remove(node);
                if (graph.get(neighbor).size() == 1) {
                    newLeaves.add(neighbor);
                }
            }
            leaves = newLeaves;
        }
        return new ArrayList<>(graph.keySet());
    }
}
