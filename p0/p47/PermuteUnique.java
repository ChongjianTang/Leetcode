package leetcode.p0.p47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermuteUnique {
    /**
     * My method
     * Recursive
     * From p46
     */
    public List<List<Integer>> permuteUnique1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        Arrays.fill(visited, false);
        backtracking1(nums, visited, new ArrayList<>(), result);
        return result;
    }

    public void backtracking1(int[] nums, boolean[] visited, List<Integer> answer, List<List<Integer>> result) {
        if (answer.size() == nums.length) {
            result.add(new ArrayList<>(answer));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])) {
                    continue;
                }
                visited[i] = true;
                answer.add(nums[i]);
                backtracking1(nums, visited, answer, result);
                answer.remove(answer.size() - 1);
                visited[i] = false;
            }
        }
    }

}
