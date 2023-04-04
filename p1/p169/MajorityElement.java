package leetcode.p1.p169;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MajorityElement {
    /**
     * Brute force
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public int majorityElement1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = nums[0];
        int num = 1;
        for (int j : nums) {
            if (map.containsKey(j)) {
                map.put(j, map.get(j) + 1);
                if (map.get(j) > max) {
                    max = map.get(j);
                    num = j;
                }
            } else {
                map.put(j, 1);
            }
        }
        return num;
    }

    /**
     * Sorting
     * Time complexity: O(nlogn)
     * Space complexity: O(1)
     * <p>
     * Fun fact: This method runs faster than the previous one in LeetCode test case!
     */
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * Randomization
     * This is an interesting idea
     * A random array index is likely to contain the majority element
     * Time complexity: Infinity
     * Space complexity: O(1)
     * <p>
     * EV(iters) <= 1*1/2 + 2*1/4 + 3*1/8 + ...
     * <p>
     * S = 1/2+2/4+3/8+...+x/2^x
     * = 2 - (x+2)/2^x
     * <p>
     * So when x -> infinity
     * EV(iters) = 2
     * The number of iterations is 2
     * Therefore, the expected runtime for the problem is linear
     */
    public static int majorityElement3(int[] nums) {
        Random r = new Random();
        while (true) {
            int num = nums[r.nextInt(nums.length)];
            int count = 0;
            for (int j : nums) {
                if (j == num) {
                    count++;
                }
            }
            if (count > nums.length / 2) {
                return num;
            }
        }
    }


    public static int majorityElement(int[] nums) {
        // TODO more methods!
        return 1;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement(nums));
    }
}
