package leetcode.p6.p621;

import java.util.*;

public class LeastInterval {
    /**
     * Mar 19, 2024 02:29
     * PriorityQueue
     * Time Complexity: O(nlogn)
     * Space COmplexity: O(nlogn)
     */
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < tasks.length; i++) {
            map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1);
        }
        PriorityQueue<Character> pq = new PriorityQueue<>((o1, o2) -> map.get(o2) - map.get(o1));
        int count = 0;
        int lastRun = 0;
        for (char c : map.keySet()) {
            pq.offer(c);
        }
        while (!pq.isEmpty()) {
            List<Character> currentTasks = new ArrayList<>();
            lastRun = 0;
            while (lastRun < n + 1 && !pq.isEmpty()) {
                char c = pq.poll();
                map.put(c, map.get(c) - 1);
                if (map.get(c) != 0) {
                    currentTasks.add(c);
                }
                lastRun++;
            }
            for (char c : currentTasks) {
                pq.offer(c);
            }
            count++;
        }
        return (count - 1) * (n + 1) + lastRun;
    }
    // TODO: my solution is way too slow. Check the Editorial
}
