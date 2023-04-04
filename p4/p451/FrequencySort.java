package leetcode.p4.p451;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FrequencySort {
    /**
     * 08/25/2022 16:03
     * My approach
     * HashMap + Heap
     */
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1);
            } else {
                int freq = map.get(s.charAt(i));
                map.put(s.charAt(i), freq + 1);
            }
        }

        PriorityQueue<Character> priorityQueue = new PriorityQueue<>((o1, o2) -> map.get(o2) - map.get(o1));

        for (char c : map.keySet()) {
            priorityQueue.add(c);
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!priorityQueue.isEmpty()) {
            char c = priorityQueue.poll();
            stringBuilder.append(("" + c).repeat(map.get(c)));
        }
        return stringBuilder.toString();
    }

    //TODO bucket sort
}
