package leetcode.p25.p2540;

import java.util.HashSet;
import java.util.Set;

public class GetCommon {
    /**
     * Mar 09, 2024 18:10
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public int getCommon(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }
        int result = -1;
        for (int i = 0; i < nums2.length; i++) {
            if (set1.contains(nums2[i])) {
                if (result == -1) {
                    result = nums2[i];
                } else {
                    result = Math.min(result, nums2[i]);
                }
            }
        }
        return result;
    }
}
