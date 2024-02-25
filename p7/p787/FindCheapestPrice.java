package leetcode.p7.p787;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class FindCheapestPrice {
    /**
     * Feb 23, 2024 02:45
     * My approach. BFS
     * Time Complexity: ?
     * Space Complexity: ?
     */
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int i = 0; i < flights.length; i++) {
            if (!graph.containsKey(flights[i][0])) {
                graph.put(flights[i][0], new HashMap<>());
            }
            graph.get(flights[i][0]).put(flights[i][1], flights[i][2]);
        }
        Map<Integer, Integer> stopPriceMap = new HashMap<>();
        stopPriceMap.put(src, 0);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(src);
        Queue<Integer> nextLevel = new LinkedList<>();
        int level = 0;

        Map<Integer, Integer> cache = new HashMap<>();
        while (!queue.isEmpty() && level != k + 1) {
            while (!queue.isEmpty()) {
                int stop = queue.poll();
                int currentPrice = stopPriceMap.get(stop);
                if (graph.containsKey(stop)) {
                    Map<Integer, Integer> nextStops = graph.get(stop);
                    for (Map.Entry<Integer, Integer> entry : nextStops.entrySet()) {
                        int nextStop = entry.getKey();
                        int flightPrice = entry.getValue();
                        if (!stopPriceMap.containsKey(nextStop)) {
                            stopPriceMap.put(nextStop, currentPrice + flightPrice);
                            if (!nextLevel.contains(nextStop)) {
                                nextLevel.offer(nextStop);
                            }
                        } else {
                            if (currentPrice + flightPrice < stopPriceMap.get(nextStop)) {
                                cache.put(nextStop, currentPrice + flightPrice);
                                if (!nextLevel.contains(nextStop)) {
                                    nextLevel.offer(nextStop);
                                }
                            }
                        }
                    }
                }
            }
            // Cache map for edge cases like test case 2
            stopPriceMap.putAll(cache);
            cache.clear();
            queue = new LinkedList<>(nextLevel);
            level++;
        }
        if (!stopPriceMap.containsKey(dst)) {
            return -1;
        } else {
            return stopPriceMap.get(dst);
        }
    }
    // TODO: Review the solution. There are many aspects of graph theory that I need to learn from this problem. This will help refresh my understanding of graph algorithms.

    public static void main(String[] args) {
        FindCheapestPrice f = new FindCheapestPrice();
        int n = 4;
        int[][] flights = new int[][]{{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};
        int src = 0;
        int dst = 3;
        int k = 1;
        System.out.println(f.findCheapestPrice(n, flights, src, dst, k) == 700);

        // Test Case 2
        n = 4;
        flights = new int[][]{{0, 1, 1}, {0, 2, 5}, {1, 2, 1}, {2, 3, 1}};
        src = 0;
        dst = 3;
        k = 1;
        System.out.println(f.findCheapestPrice(n, flights, src, dst, k) == 6);
    }
}
