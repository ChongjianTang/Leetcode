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
    public static boolean canCross1(int[] stones) {
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

    /**
     * Feb 11, 2024 00:04
     * Bottom up DP, an excellent example of DP.
     * Time Complexity: O(n^2)
     * Space Complexity: O(n^2)
     */
    public static boolean canCross(int[] stones) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            map.put(stones[i], new HashSet<>());
        }

        map.get(0).add(1);
        for (int i = 0; i < stones.length; i++) {
            Set<Integer> canJump = map.get(stones[i]);
            for (int jump : canJump) {
                if (map.containsKey(stones[i] + jump)) {
                    Set<Integer> nextCanJump = map.get(stones[i] + jump);
                    if (jump - 1 > 0) {
                        nextCanJump.add(jump - 1);
                    }
                    nextCanJump.add(jump);
                    nextCanJump.add(jump + 1);
                }
            }
        }
        return !map.get(stones[stones.length - 1]).isEmpty();
    }

    public static void main(String[] args) {
        int[] stones = new int[]{0, 1, 3, 5, 6, 8, 12, 17};
        System.out.println(canCross(stones));

        stones = new int[]{0, 1, 3, 6, 10, 15, 16, 21};
        System.out.println(canCross(stones));
    }


}
