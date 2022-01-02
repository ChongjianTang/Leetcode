package leetcode.p15;

import java.util.*;

public class ThreeSum {
    /**
     * Brute-Force with ignoring duplicated elements
     */
    public static List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) {
            return result;
        }
        HashSet<Integer> visited = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (!visited.contains(nums[i])) {
                visited.add(nums[i]);
                for (int j = i + 1; j < nums.length - 1; j++) {
                    for (int k = j + 1; k < nums.length; k++) {
                        if (nums[i] + nums[j] + nums[k] == 0) {
                            List<Integer> triplets = new ArrayList<>();
                            triplets.add(nums[i]);
                            triplets.add(nums[j]);
                            triplets.add(nums[k]);
                            triplets.sort(Comparator.comparingInt(o -> o));
                            if (!result.contains(triplets)) {
                                result.add(triplets);
                            }
                            break;
                        }
                    }
                }
            }
        }
        return result;
    }

    /**
     * Use p1-twoSum and ignore duplicated elements
     */
    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>();
        if (nums.length < 3) {
            return result;
        }
        HashSet<Integer> visited = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (!visited.contains(nums[i])) {
                visited.add(nums[i]);
                HashSet<int[]> twoSumArrays = twoSum(nums, i + 1, -1 * nums[i]);
                for (int[] temp : twoSumArrays) {
                    List<Integer> triplets = new ArrayList<>();
                    triplets.add(nums[i]);
                    triplets.add(temp[0]);
                    triplets.add(temp[1]);
                    triplets.sort(Comparator.comparingInt(o -> o));
                    set.add(triplets);
                }
            }
        }
        result.addAll(set);
        return result;
    }

    public static HashSet<int[]> twoSum(int[] nums, int start, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<int[]> result = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result.add(new int[]{nums[i], target - nums[i]});
            } else {
                map.put(nums[i], i);
            }
        }
        return result;
    }

    /**
     * Two point trick
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        int i = 0;
        while (i < nums.length - 2) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                } else if (nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                } else {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    result.add(temp);
                    while (j + 1 < nums.length && nums[j] == nums[j + 1]) {
                        j++;
                    }
                    j++;
                    while (k - 1 >= 0 && nums[k] == nums[k - 1]) {
                        k--;
                    }
                    k--;
                }
            }
            while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                i++;
            }
            i++;
        }
        return result;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }
}
