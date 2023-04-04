package leetcode.p3.p332;

import java.util.*;

public class FindItinerary {
    /**
     * DFS without pruning
     * TLE - 11/80
     */
    public List<String> findItinerary1(List<List<String>> tickets) {
        Map<String, List<String>> graph = new HashMap<>();
        for (List<String> ticket : tickets) {
            if (!graph.containsKey(ticket.get(0))) {
                graph.put(ticket.get(0), new ArrayList<>());
            }
            graph.get(ticket.get(0)).add(ticket.get(1));
        }

        // Pruning 1
        for (List<String> edges : graph.values()) {
            Collections.sort(edges);
        }

        List<String> finalResult = new ArrayList<>();
        List<String> result = new ArrayList<>();
        result.add("JFK");
        dfs1(graph, "JFK", 0, tickets.size(), result, finalResult);
        return finalResult;
    }

    public static void dfs1(Map<String, List<String>> graph, String start, int index, int total, List<String> result, List<String> finalResult) {
        if (index == total) {
            if (finalResult.isEmpty() || compareTo1(result, finalResult)) {
                finalResult.clear();
                finalResult.addAll(result);
            }
            return;
        }
        if (!graph.containsKey(start) || graph.get(start).size() == 0) {
            return;
        }
        if (!finalResult.isEmpty() && !compareTo1(result, finalResult)) {
            return;
        }

        List<String> nextStops = graph.get(start);
        for (int i = 0; i < nextStops.size(); i++) {
            String temp = nextStops.get(i);
            result.add(temp);
            nextStops.remove(i);
            dfs1(graph, temp, index + 1, total, result, finalResult);
            nextStops.add(i, temp);
            result.remove(result.size() - 1);
        }
    }

    private static boolean compareTo1(List<String> result, List<String> finalResult) {
        for (int i = 0; i < result.size(); i++) {
            String s1 = result.get(i);
            String s2 = finalResult.get(i);
            if (s1.compareTo(s2) < 0) {
                return true;
            } else if (s1.compareTo(s2) > 0) {
                return false;
            }
        }
        return false;
    }
}
