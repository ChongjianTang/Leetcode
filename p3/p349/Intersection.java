package leetcode.p3.p349;

import java.util.HashSet;
import java.util.Set;

public class Intersection {
    /**
     * 08/30/2022 11:47
     * Two sets
     * Time complexity: O(n+m)
     * Space complexity: O(n+m)
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }

        Set<Integer> result = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                result.add(nums2[i]);
            }
        }

        int[] temp = new int[result.size()];
        int i = 0;
        for (int num : result) {
            temp[i] = num;
            i++;
        }
        return temp;
    }
}
