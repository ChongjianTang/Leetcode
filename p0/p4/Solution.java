package leetcode.p0.p4;

import java.util.PriorityQueue;

public class Solution {
    public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        return helper(nums1, 0, nums1.length, nums2, 0, nums2.length);
    }

    public static double helper(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2) {
        if (start1 == end1) {
            return getMedian(nums2, start2, end2);
        }
        if (start2 == end2) {
            return getMedian(nums1, start1, end1);
        }
        double median1 = getMedian(nums1, start1, end1);
        double median2 = getMedian(nums2, start2, end2);
        if (median1 == median2) {
            return median1;
        } else if (median1 < median2) {
            int length = Math.min(end2 - (start2 + end2) / 2 - 1, (start1 + end1 - 1) / 2 - start1);
            if (length == 0) {
                return solve(nums1, start1, end1, nums2, start2, end2);
            } else {
                return helper(nums1, start1 + length, end1, nums2, start2, end2 - length);
            }
        } else {
            int length = Math.min(end1 - (start1 + end1) / 2 - 1, (start2 + end2 - 1) / 2 - start2);
            if (length == 0) {
                return solve(nums1, start1, end1, nums2, start2, end2);
            } else {
                return helper(nums2, start2 + length, end2, nums1, start1, end1 - length);
            }
        }
    }

    private static double solve(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int temp1 = (start1 + end1) / 2;
        if ((end1 - start1) % 2 == 0) {
            queue.add(nums1[temp1]);
            queue.add(nums1[temp1 - 1]);
            if (end1 - start1 > 2) {
                queue.add(nums1[temp1 - 2]);
                queue.add(nums1[temp1 + 1]);
            }
        } else {
            queue.add(nums1[temp1]);
            if (end1 - start1 > 1) {
                queue.add(nums1[temp1 + 1]);
                queue.add(nums1[temp1 - 1]);
            }
        }
        int temp2 = (start2 + end2) / 2;
        if ((end2 - start2) % 2 == 0) {
            queue.add(nums2[temp2]);
            queue.add(nums2[temp2 - 1]);
            if (end2 - start2 > 2) {
                queue.add(nums2[temp2 - 2]);
                queue.add(nums2[temp2 + 1]);
            }
        } else {
            queue.add(nums2[temp2]);
            if (end2 - start2 > 1) {
                queue.add(nums2[temp2 + 1]);
                queue.add(nums2[temp2 - 1]);
            }
        }
        int length = queue.size();
        if (length % 2 == 0) {
            for (int i = 0; i < length / 2 - 1; i++) {
                queue.poll();
            }
            return (queue.poll() + queue.poll()) / 2.0;
        } else {
            for (int i = 0; i < length / 2; i++) {
                queue.poll();
            }
            return queue.poll();
        }
    }

    private static double getMedian(int[] nums, int start, int end) {
        int temp = (start + end) / 2;
        if ((end - start) % 2 == 0) {
            return (nums[temp] + nums[temp - 1]) / 2.0;
        } else {
            return nums[temp];
        }
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = nums1.length / 2;
        int j = (nums1.length + nums2.length + 1) / 2 - i;

        int start = 0;
        int end = nums1.length;
        while (true) {
            int temp1 = get(nums2, j - 1);
            int temp2 = get(nums1, i - 1);
            int temp3 = get(nums1, i);
            int temp4 = get(nums2, j);
            if (temp1 <= temp3 && temp2 <= temp4) {
                if ((nums1.length + nums2.length) % 2 == 0) {
                    int a = Math.max(temp1, temp2);
                    int b = Math.min(temp3, temp4);
                    return (a + b) / 2.0;
                } else {
                    return Math.max(temp1, temp2);
                }
            } else {
                if (temp1 > temp3) {
                    start = i + 1;
                    i = (i + 1 + end) / 2;
                } else {
                    end = i - 1;
                    i = (start + i - 1) / 2;
                }
                j = (nums1.length + nums2.length + 1) / 2 - i;

            }
        }
    }

    public static int get(int[] nums, int i) {
        if (i < 0) {
            return Integer.MIN_VALUE;
        } else if (i >= nums.length) {
            return Integer.MAX_VALUE;
        } else {
            return nums[i];
        }
    }

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{}, new int[]{}));
    }
}
