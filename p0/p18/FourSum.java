package leetcode.p0.p18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 4) {
            return result;
        }
        Arrays.sort(nums);
        int i = 0;
        int j = 1;
        while (i < nums.length - 3) {
            if (nums[i] > target / 4) {
                break;
            }
            int m = j + 1;
            int n = nums.length - 1;
            while (m < n) {
                int value = nums[i] + nums[j] + nums[m] + nums[n];
                int avg = (target - nums[i] - nums[j]) / 2;
                if (nums[m] > avg || nums[n] < avg) {
                    break;
                }
                if (value < target) {
                    m++;
                } else if (value > target) {
                    n--;
                } else {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[m]);
                    temp.add(nums[n]);
                    result.add(temp);
                    while (m + 1 < nums.length - 1 && nums[m] == nums[m + 1]) {
                        m++;
                    }
                    m++;
                    while (n - 1 >= 1 && nums[n] == nums[n - 1]) {
                        n--;
                    }
                    n--;
                }
            }
            if (j + 1 < nums.length) {
                while (j + 1 < nums.length - 2 && nums[j] == nums[j + 1]) {
                    j++;
                }
                j++;
                if (nums[j] > (target - nums[i]) / 3) {
                    while (i + 1 < nums.length - 3 && nums[i] == nums[i + 1]) {
                        i++;
                    }
                    i++;
                    j = i + 1;
                }
            } else {
                while (i + 1 < nums.length - 3 && nums[i] == nums[i + 1]) {
                    i++;
                }
                i++;
                j = i + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        System.out.println(fourSum(nums, 0));
    }
}
