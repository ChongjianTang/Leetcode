package leetcode.p9.p992;

import java.util.HashMap;
import java.util.Map;

public class SubarraysWithKDistinct {
    /**
     * Mar 29, 2024 23:21
     * My sliding windows
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public int subarraysWithKDistinct(int[] nums, int k) {
        int leftEnd = 0;
        int leftStart = -1;
        int result = 0;
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!frequencyMap.containsKey(nums[i])) {
                frequencyMap.put(nums[i], 1);
            } else {
                frequencyMap.put(nums[i], frequencyMap.get(nums[i]) + 1);
            }
            while (leftEnd < nums.length && frequencyMap.size() > k) {
                int frequency = frequencyMap.get(nums[leftEnd]);
                if (frequency == 1) {
                    frequencyMap.remove(nums[leftEnd]);
                    leftStart = leftEnd;
                } else {
                    frequencyMap.put(nums[leftEnd], frequency - 1);
                }
                leftEnd++;
            }
            if (frequencyMap.size() == k) {
                while (leftEnd < nums.length) {
                    if (frequencyMap.get(nums[leftEnd]) > 1) {
                        frequencyMap.put(nums[leftEnd], frequencyMap.get(nums[leftEnd]) - 1);
                    } else {
                        break;
                    }
                    leftEnd++;
                }
                result += leftEnd - leftStart;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SubarraysWithKDistinct s = new SubarraysWithKDistinct();
        int[] nums;
        int k;

        nums = new int[]{1, 2, 1, 2, 3};
        k = 2;

        System.out.println(s.subarraysWithKDistinct(nums, k) == 7);
    }
}
