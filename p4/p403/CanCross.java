package leetcode.p4.p403;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CanCross {
    /**
     * DP
     * Time complexity: O(n^2)
     * Space complexity: O(n^2)
     */
    public static boolean canCross(int[] stones) {
        Map<Integer, Set<Integer>> dp = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            dp.put(stones[i], new HashSet<>());
        }
        dp.get(0).add(1);
        for (int stone : stones) {
            for (int jump : dp.get(stone)) {
                if (dp.containsKey(stone + jump)) {
                    Set<Integer> set = dp.get(stone + jump);
                    if (jump - 1 > 0) {
                        set.add(jump - 1);
                    }
                    set.add(jump);
                    set.add(jump + 1);
                }
            }
        }
        return !dp.get(stones[stones.length - 1]).isEmpty();
    }

    public static void main(String[] args) {
        int[] stones = new int[]{0, 1, 3, 5, 6, 8, 12, 17};
        System.out.println(canCross(stones));
    }
}
