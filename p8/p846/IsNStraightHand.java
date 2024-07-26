package leetcode.p8.p846;

import java.util.TreeMap;

public class IsNStraightHand {
    /**
     * Jun 06, 2024 22:58
     * TreeMap
     * Time Complexity: O(nlogn)
     * Space Complexity: O(n)
     */
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < hand.length; i++) {
            map.put(hand[i], map.getOrDefault(hand[i], 0) + 1);
        }

        while (!map.isEmpty()) {
            int num = map.firstKey();
            if (map.get(num) == 1) {
                map.remove(num);
            } else {
                map.put(num, map.get(num) - 1);
            }
            for (int i = 1; i < groupSize; i++) {
                num++;
                if (map.containsKey(num)) {
                    if (map.get(num) == 1) {
                        map.remove(num);
                    } else {
                        map.put(num, map.get(num) - 1);
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
