package leetcode.p12.p1207;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class UniqueOccurrences {
    /**
     * Brute Force
     * Mar 11, 2023 16:31
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], 1);
            } else {
                map.put(arr[i], map.get(arr[i]) + 1);
            }
        }

        Set<Integer> set = new HashSet<>(map.values());
        return set.size() == map.keySet().size();
    }

}
