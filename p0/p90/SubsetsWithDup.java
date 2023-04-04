package leetcode.p0.p90;

import java.util.*;

public class SubsetsWithDup {
    /**
     * My method
     * Use hashSet to remove duplicates
     */
    public List<List<Integer>> subsetsWithDup1(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        backtracking1(nums, 0, new ArrayList<>(), result);
        return new ArrayList<>(result);
    }

    public void backtracking1(int[] nums, int start, List<Integer> subset, Set<List<Integer>> result) {
        if (start == nums.length) {
            List<Integer> temp = new ArrayList<>(subset);
            temp.sort(Comparator.comparingInt(o -> o));
            result.add(new ArrayList<>(temp));
        } else {
            subset.add(nums[start]);
            backtracking1(nums, start + 1, subset, result);
            subset.remove(subset.size() - 1);
            backtracking1(nums, start + 1, subset, result);
        }
    }

    /**
     * My method
     * Better one
     * If we don't choose k, then we will skip all k!
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        backtracking1(nums, 0, new ArrayList<>(), result);
        return new ArrayList<>(result);
    }

    public void backtracking1(int[] nums, int start, List<Integer> subset, List<List<Integer>> result) {
        if (start == nums.length) {
            result.add(new ArrayList<>(subset));
        } else {
            subset.add(nums[start]);
            backtracking1(nums, start + 1, subset, result);
            subset.remove(subset.size() - 1);
            while (start < nums.length - 1 && nums[start] == nums[start + 1]) {
                start++;
            }
            backtracking1(nums, start + 1, subset, result);
        }
    }
}
