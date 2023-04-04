package leetcode.p0.p88;

import java.util.Arrays;

public class Merge {
    /**
     * My approach
     * Three pointers
     * Time complexity: O(m+n)
     * Space complexity: O(1)
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        if (m == 0) {
            System.arraycopy(nums2, 0, nums1, 0, n);
        }
        int i = m - 1;
        int j = n - 1;
        int k = nums1.length - 1;
        while (i != -1 && j != -1) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
        if (i == -1) {
            System.arraycopy(nums2, 0, nums1, 0, j + 1);
        }
    }


    public static void main(String[] args) {
        int[] nums1, nums2;
        int[] output;
        int m, n;

        nums1 = new int[]{1, 2, 3, 0, 0, 0};
        nums2 = new int[]{2, 5, 6};
        m = 3;
        n = 3;
        merge(nums1, m, nums2, n);
        output = new int[]{1, 2, 2, 3, 5, 6};
        System.out.println(Arrays.equals(nums1, output));

        nums1 = new int[]{2, 0};
        m = 1;
        nums2 = new int[]{1};
        n = 1;
        merge(nums1, m, nums2, n);
        output = new int[]{1, 2};
        System.out.println(Arrays.equals(nums1, output));

        nums1 = new int[]{4, 0, 0, 0, 0, 0};
        m = 1;
        nums2 = new int[]{1, 2, 3, 5, 6};
        n = 5;
        merge(nums1, m, nums2, n);
        output = new int[]{1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.equals(nums1, output));
    }
}
