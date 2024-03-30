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
    public List<Integer> findMinHeightTrees2(int n, int[][] edges) {
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


    public int[] dfs(Map<Integer, Set<Integer>> graph, Map<Integer, List<Integer>> paths, int start) {
        int[] result = new int[2];
        Set<Integer> visited = new HashSet<>();
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{start, 0});
        paths.put(start, new ArrayList<>());
        paths.get(start).add(start);
        while (!stack.isEmpty()) {
            int[] node = stack.pop();
            visited.add(node[0]);
            if (node[1] > result[1]) {
                result = node;
            }
            for (int nextNode : graph.get(node[0])) {
                if (!visited.contains(nextNode)) {
                    stack.push(new int[]{nextNode, node[1] + 1});
                    List<Integer> currentPath = new ArrayList<>(paths.get(node[0]));
                    currentPath.add(nextNode);
                    paths.put(nextNode, currentPath);
                }
            }
        }
        return result;
    }

    /**
     * Memory Limit Exceeded
     * The bottleneck is the pathMap
     */
    public List<Integer> findMinHeightTrees3(int n, int[][] edges) {
        if (edges.length == 0) {
            return new ArrayList<>(List.of(0));
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
        Map<Integer, List<Integer>> pathMap = new HashMap<>();
        int[] result = dfs(graph, pathMap, 0);
        pathMap.clear();
        result = dfs(graph, pathMap, result[0]);
        List<Integer> path = pathMap.get(result[0]);
        if (path.size() % 2 == 0) {
            return path.subList(path.size() / 2 - 1, path.size() / 2 + 1);
        } else {
            return path.subList(path.size() / 2, path.size() / 2 + 1);
        }
    }

    int maxPathLength = 0;
    List<Integer> longestPath = new ArrayList<>();

    int maxDepthNode = 0;

    public void recursiveDFS(Map<Integer, Set<Integer>> graph, Set<Integer> visited, List<Integer> path, int start) {
        visited.add(start);
        path.add(start);

        if (path.size() > maxPathLength) {
            maxPathLength = path.size();
            longestPath = new ArrayList<>(path);
            maxDepthNode = start;
        }

        for (int nextNode : graph.get(start)) {
            if (!visited.contains(nextNode)) {
                recursiveDFS(graph, visited, path, nextNode);
            }
        }

        path.remove(path.size() - 1);
    }

    /**
     * Feb 28, 2024 10:16
     * Two dfs and find the middle point(s)
     * Time Complexity: O(node.size)
     * Space Complexity: O(tree.height)
     */
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        maxDepthNode = 0;
        maxPathLength = 0;
        longestPath.clear();
        if (edges.length == 0) {
            return new ArrayList<>(List.of(0));
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

        recursiveDFS(graph, new HashSet<>(), new ArrayList<>(), maxDepthNode);
        maxPathLength = 0;
        longestPath.clear();
        recursiveDFS(graph, new HashSet<>(), new ArrayList<>(), maxDepthNode);

        if (longestPath.size() % 2 == 0) {
            return longestPath.subList(longestPath.size() / 2 - 1, longestPath.size() / 2 + 1);
        } else {
            return longestPath.subList(longestPath.size() / 2, longestPath.size() / 2 + 1);
        }
    }


    public static void main(String[] args) {
        FindMinHeightTrees f = new FindMinHeightTrees();
        int n = 4;
        int[][] edges = new int[][]{{1, 0}, {1, 2}, {1, 3}};

        Set<Integer> output = new HashSet<>();
        output.add(1);
        List<Integer> result = f.findMinHeightTrees(n, edges);
        Set<Integer> resultSet = new HashSet<>(result);
        if (resultSet.size() != result.size()) {
            System.out.println("false");
        } else {
            System.out.println(resultSet.equals(output));
        }


        n = 12;
        edges = new int[][]{{0, 1}, {0, 2}, {0, 3}, {3, 4}, {3, 5}, {1, 6}, {4, 7}, {2, 8}, {0, 9}, {0, 10}, {2, 11}};

        output = new HashSet<>();
        output.add(0);
        output.add(3);
        result = f.findMinHeightTrees(n, edges);
        resultSet = new HashSet<>(result);
        if (resultSet.size() != result.size()) {
            System.out.println("false");
        } else {
            System.out.println(resultSet.equals(output));
        }
    }
}
