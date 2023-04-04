package leetcode.p15.p1570;


/**
 * Non-efficient Array Approach
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
class SparseVector1 {
    private int[] nums;

    SparseVector1(int[] nums) {
        this.nums = nums;
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector1 vec) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] * vec.nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        SparseVector1 v1, v2;
        int[] nums1, nums2;
        int output;
        nums1 = new int[]{1, 0, 0, 2, 3};
        nums2 = new int[]{0, 3, 0, 4, 0};
        v1 = new SparseVector1(nums1);
        v2 = new SparseVector1(nums2);
        output = 8;
        System.out.println(v1.dotProduct(v2) == 8);
    }
}

public class SparseVector {


    SparseVector(int[] nums) {
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        // TODO to find more efficient solution.
        return 0;
    }
}
