package leetcode.p8.p815;

import java.awt.*;
import java.util.*;
import java.util.List;

public class NumBusesToDestination {
    /**
     * Brute Force for me
     * 523ms at first
     */
    public static int numBusesToDestination1(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }
        int count = 1;


        long startTime = System.currentTimeMillis();

        ArrayList<HashSet<Integer>> routesSet = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int[] route : routes) {
            HashSet<Integer> temp = new HashSet<>();
            for (int j = 0; j < route.length; j++) {
                temp.add(route[j]);
            }
            if (temp.contains(source)) {
                set.addAll(temp);
            } else {
                routesSet.add(temp);
            }
        }


        boolean[] visited = new boolean[routesSet.size()];

        long endTime = System.currentTimeMillis();

        System.out.println("Prepare Time: " + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();


        Arrays.fill(visited, false);
        while (!set.contains(target)) {
            boolean flag = false;

            HashSet<Integer> nextBusRoutes = new HashSet<>();
            for (int i = 0; i < routesSet.size(); i++) {
                if (!visited[i]) {
                    HashSet<Integer> route = routesSet.get(i);
                    if (check1(set, route)) {
                        nextBusRoutes.addAll(route);
                        visited[i] = true;
                        flag = true;
                    }
                }
            }
            set.addAll(nextBusRoutes);
            if (!flag) {
                return -1;
            } else {
                count++;
            }
        }

        endTime = System.currentTimeMillis();
        System.out.println("Loop Time: " + (endTime - startTime) + "ms");
        return count;
    }

    public static boolean check1(HashSet<Integer> set1, HashSet<Integer> set2) {
        for (int num : set2) {
            if (set1.contains(num)) {
                return true;
            }
        }
        return false;
    }


    /**
     * Solution:
     * Breadth First Search
     */
    public static int numBusesToDestination2(int[][] routes, int source, int target) {
        if (source == target) return 0;

        int N = routes.length;

        List<List<Integer>> graph = new ArrayList();
        for (int i = 0; i < N; ++i) {
            Arrays.sort(routes[i]);
            graph.add(new ArrayList());
        }
        Set<Integer> seen = new HashSet();
        Set<Integer> targets = new HashSet();
        Queue<Point> queue = new ArrayDeque();

        // Build the graph.  Two buses are connected if
        // they share at least one bus stop.


        for (int i = 0; i < N; ++i) {
            for (int j = i + 1; j < N; ++j) {
                if (intersect(routes[i], routes[j])) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }

        // Initialize seen, queue, targets.
        // seen represents whether a node has ever been enqueued to queue.
        // queue handles our breadth first search.
        // targets is the set of goal states we have.
        for (int i = 0; i < N; ++i) {
            if (Arrays.binarySearch(routes[i], source) >= 0) {
                seen.add(i);
                queue.offer(new Point(i, 0));
            }
            if (Arrays.binarySearch(routes[i], target) >= 0)
                targets.add(i);
        }

        while (!queue.isEmpty()) {
            Point info = queue.poll();
            int node = info.x, depth = info.y;
            if (targets.contains(node)) {
                return depth + 1;
            }
            for (Integer nei : graph.get(node)) {
                if (!seen.contains(nei)) {
                    seen.add(nei);
                    queue.offer(new Point(nei, depth + 1));
                }
            }
        }
        return -1;
    }

    public static boolean intersect(int[] A, int[] B) {
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            if (A[i] == B[j]) return true;
            if (A[i] < B[j]) i++;
            else j++;
        }
        return false;
    }


    /**
     * My version of BFS
     * Still super slow -- 643ms
     * HashSet may not be a good idea.
     * The key problem is checking funciton.
     */
    public static int numBusesToDestination3(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }
        int count = 1;
        int len = routes.length;

        long startTime = System.currentTimeMillis();
        List<HashSet<Integer>> routeSet = new ArrayList<>();
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            HashSet<Integer> temp = new HashSet<>();
            graph.add(new ArrayList<>());
            for (int stop : routes[i]) {
                temp.add(stop);
            }
            routeSet.add(temp);
        }

        long endTime = System.currentTimeMillis();

        System.out.println("HashSet Time: " + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();

        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (check3(routeSet.get(i), routeSet.get(j))) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }
        endTime = System.currentTimeMillis();

        System.out.println("Graph Time: " + (endTime - startTime) + "ms");

        boolean[] visited = new boolean[len];
        Arrays.fill(visited, false);
        Queue<int[]> openList = new ArrayDeque<>();
        for (int i = 0; i < graph.size(); i++) {
            if (routeSet.get(i).contains(source)) {
                if (routeSet.get(i).contains(target)) {
                    return count;
                }
                openList.add(new int[]{i, 1});
            }
        }

        while (!openList.isEmpty()) {
            int[] node = openList.poll();
            if (routeSet.get(node[0]).contains(target)) {
                return node[1];
            }
            for (int stop : graph.get(node[0])) {
                if (!visited[stop]) {
                    openList.add(new int[]{stop, node[1] + 1});
                    visited[stop] = true;
                }
            }
        }
        return -1;
    }

    /**
     * A solution in discuss.
     * It uses stops to build graph instead of the bus routes
     */
    public static int numBusesToDestination(int[][] routes, int source, int target) {
        Map<Integer, List<Integer>> graph = new HashMap<>();  // key: stop, value: list of bus id
        buildGraph(graph, routes);
        if (!graph.containsKey(source) || !graph.containsKey(target)) return -1;
        if (source == target) return 0;
        Set<Integer> busSet = new HashSet<>();
        Set<Integer> stopSet = new HashSet<>();
        Queue<Integer> que = new ArrayDeque<>();
        que.add(source);
        int count = 1;
        while (!que.isEmpty()) {
            int size = que.size();
            for (int k = 0; k < size; k++) {
                int curStop = que.poll();
                for (Integer bus : graph.getOrDefault(curStop, List.of())) {
                    if (!busSet.add(bus)) {  // already taken the bus
                        continue;
                    }
                    for (int nextStop : routes[bus]) {
                        if (nextStop == target) return count;
                        if (stopSet.add(nextStop)) {  // not visited this stop yet
                            que.add(nextStop);
                        }
                    }
                }
            }
            count++;
        }
        return -1;
    }

    private static void buildGraph(Map<Integer, List<Integer>> graph, int[][] routes) {
        for (int bus = 0; bus < routes.length; bus++) {
            int[] route = routes[bus];
            for (int stop : route) {
                List<Integer> list = graph.getOrDefault(stop, new ArrayList<>());
                if (list.isEmpty()) {
                    graph.put(stop, list);
                }
                list.add(bus);
            }
        }
    }

    public static boolean check3(HashSet<Integer> set1, HashSet<Integer> set2) {
        HashSet<Integer> first, second;
        if (set1.size() < set2.size()) {
            first = set1;
            second = set2;
        } else {
            first = set2;
            second = set1;
        }
        for (int stop : first) {
            if (second.contains(stop)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] routes;

        routes = new int[500][501];
        for (int i = 0; i < 500; i++) {
            for (int j = 0; j < 501; j++) {
                routes[i][j] = 500 * i + j;
            }
        }

        long startTime = System.currentTimeMillis();

        System.out.println(numBusesToDestination(routes, 0, 250000) == 500);

        long endTime = System.currentTimeMillis();

        System.out.println("Time: " + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        System.out.println(numBusesToDestination2(routes, 0, 250000) == 500);
        endTime = System.currentTimeMillis();

        System.out.println("Time: " + (endTime - startTime) + "ms");


        routes = new int[][]{
                {10, 13, 22, 28, 32, 35, 43},
                {2, 11, 15, 25, 27},
                {6, 13, 18, 25, 42},
                {5, 6, 20, 27, 37, 47},
                {7, 11, 19, 23, 35},
                {7, 11, 17, 25, 31, 43, 46, 48},
                {1, 4, 10, 16, 25, 26, 46},
                {7, 11},
                {3, 9, 19, 20, 21, 24, 32, 45, 46, 49},
                {11, 41}
        };
        System.out.println(numBusesToDestination(routes, 37, 43) == 3);

        routes = new int[][]{
                {1, 7},
                {3, 5}
        };
        System.out.println(numBusesToDestination(routes, 5, 5) == 0);

        routes = new int[][]{
                {25, 33},
                {3, 5, 13, 22, 23, 29, 37, 45, 49},
                {15, 16, 41, 47},
                {5, 11, 17, 23, 33},
                {10, 11, 12, 29, 30, 39, 45},
                {2, 5, 23, 24, 33},
                {1, 2, 9, 19, 20, 21, 23, 32, 34, 44},
                {7, 18, 23, 24},
                {1, 2, 7, 27, 36, 44},
                {7, 14, 33}
        };

        System.out.println(numBusesToDestination(routes, 7, 47) == -1);

        routes = new int[][]{
                {1, 2, 7},
                {3, 6, 7}
        };
        System.out.println(numBusesToDestination(routes, 1, 6) == 2);

        routes = new int[][]{
                {7, 12},
                {4, 5, 15},
                {6},
                {15, 19},
                {9, 12, 13}
        };
        System.out.println(numBusesToDestination(routes, 15, 12) == -1);
    }
}
