package leetcode.p0.p78;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    /**
     * My method
     * Time complexity: O(n*2^n)
     * Similar to problem 17
     * Space complexity: O(n)
     */
    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking1(nums, 0, new ArrayList<>(), result);
        return result;
    }

    public void backtracking1(int[] nums, int start, List<Integer> subset, List<List<Integer>> result) {
        if (start == nums.length) {
            result.add(new ArrayList<>(subset));
        } else {
            subset.add(nums[start]);
            backtracking1(nums, start + 1, subset, result);
            subset.remove(subset.size() - 1);
            backtracking1(nums, start + 1, subset, result);
        }
    }

    /**
     * My method
     * Another way of recursion
     * A faster one
     */
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking2(nums, 0, new ArrayList<>(), result);
        return result;
    }

    public static void backtracking2(int[] nums, int start, List<Integer> subset, List<List<Integer>> result) {
        if (start == nums.length) {
            result.add(new ArrayList<>(subset));
        } else {
            for (int i = start; i < nums.length; i++) {
                subset.add(nums[i]);
                backtracking2(nums, i + 1, subset, result);
                subset.remove(subset.size() - 1);
            }
            backtracking2(nums, nums.length, subset, result);
        }
    }

    public static void main(String[] args) {
        subsets(new int[]{1, 2, 3});
    }


    // TODO there are two more methods in the Solution part. Check them.
}
