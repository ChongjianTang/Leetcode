package leetcode.p0.p46;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Permute {
    /**
     * My method
     * Recursive
     * List.contains() is not efficient -- O(n)
     * This method runs not bad in LeetCode
     * 10!=3,628,800 and 9!=362,880 so the space cost for testing is so huge.
     * So the testcase can not be too huge.
     * Time complexity: too complicated
     */
    public List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking1(nums, new ArrayList<>(), result);
        return result;
    }

    public void backtracking1(int[] nums, List<Integer> answer, List<List<Integer>> result) {
        if (answer.size() == nums.length) {
            result.add(new ArrayList<>(answer));
        } else {
            for (int num : nums) {
                if (!answer.contains(num)) {
                    answer.add(num);
                    backtracking1(nums, answer, result);
                    answer.remove(answer.size() - 1);
                }
            }
        }
    }

    /**
     * swap
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking2(nums, 0, result);
        return result;
    }

    public void backtracking2(int[] nums, int index, List<List<Integer>> result) {
        if (index == nums.length - 1) {
            List<Integer> answer = new ArrayList<>();
            for (int num : nums) {
                answer.add(num);
            }
            result.add(answer);
        } else {
            for (int i = index; i < nums.length; i++) {
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
                backtracking2(nums, index + 1, result);
                nums[i] = nums[index];
                nums[index] = temp;
            }
        }
    }
}
