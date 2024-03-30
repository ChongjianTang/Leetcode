package leetcode.p7.p791;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class CustomSortString {
    /**
     * Mar 10, 2024 19:27
     * Priority Queue
     * Time Complexity: O(nlogn)
     * Space Complexity: O(n)
     */
    public String customSortString1(String order, String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }
        PriorityQueue<Character> pq = new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return map.getOrDefault(o1, Integer.MAX_VALUE) - map.getOrDefault(o2, Integer.MAX_VALUE);
            }
        });
        for (int i = 0; i < s.length(); i++) {
            pq.offer(s.charAt(i));
        }
        StringBuilder result = new StringBuilder();
        while (!pq.isEmpty()) {
            result.append(pq.poll());
        }
        return result.toString();
    }

    /**
     * Mar 11, 2024 18:26
     * Frequency Table
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public String customSortString(String order, String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < order.length(); i++) {
            if (map.containsKey(order.charAt(i))) {
                String letter = order.charAt(i) + "";
                result.append(letter.repeat(map.get(order.charAt(i))));
                map.remove(order.charAt(i));
            }
        }
        if (!map.isEmpty()) {
            for (char key : map.keySet()) {

                String letter = "" + key;
                result.append(letter.repeat(map.get(key)));
            }
        }
        return result.toString();
    }
}
