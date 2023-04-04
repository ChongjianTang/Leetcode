package leetcode.p4.p421;

import com.sun.source.tree.Tree;

import java.util.HashSet;
import java.util.Set;

public class FindMaximumXOR {
    /**
     * 08/31/2022 19:46
     * Brute force
     * TLE - 41/42
     * Time complexity: O(n^2)
     * Space complexity: O(1)
     */
    public int findMaximumXOR1(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                max = Math.max(nums[i] ^ nums[j], max);
            }
        }
        return max;
    }

    /**
     * 09/03/2022 18:35
     * Bitwise Prefixes in HashSet
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public static int findMaximumXOR2(int[] nums) {
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            len = Math.max(Integer.toBinaryString(nums[i]).length(), len);
        }

        int max = 0;
        Set<Integer> prefixes = new HashSet<>();
        for (int i = len - 1; i >= 0; i--) {
            max = max << 1;
            int curr = max | 1;
            prefixes.clear();
            for (int j = 0; j < nums.length; j++) {
                prefixes.add(nums[j] >> i);
            }

            for (int prefix : prefixes) {
                if (prefixes.contains(curr ^ prefix)) {
                    max = curr;
                    break;
                }
            }
        }
        return max;
    }


    /**
     * 09/04/2022 18:30
     * Bitwise Trie Tree
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public static int findMaximumXOR(int[] nums) {
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            len = Math.max(Integer.toBinaryString(nums[i]).length(), len);
        }

        TreeNode root = new TreeNode();
        for (int i = 0; i < nums.length; i++) {
            TreeNode temp = root;
            for (int j = len - 1; j >= 0; j--) {
                if ((nums[i] >> j & 1) == 0) {
                    if (temp.zero == null) {
                        temp.zero = new TreeNode();
                    }
                    temp = temp.zero;
                } else {
                    if (temp.one == null) {
                        temp.one = new TreeNode();
                    }
                    temp = temp.one;
                }
            }
        }

        int max = Integer.MIN_VALUE;
        int cur = 0;

        for (int i = 0; i < nums.length; i++) {
            TreeNode temp = root;
            cur = 0;
            for (int j = len - 1; j >= 0; j--) {
                cur = cur << 1;
                if ((nums[i] >> j & 1) == 0) {
                    if (temp.one != null) {
                        cur = cur | 1;
                        temp = temp.one;
                    } else {
                        temp = temp.zero;
                    }
                } else {
                    if (temp.zero != null) {
                        cur = cur | 1;
                        temp = temp.zero;
                    } else {
                        temp = temp.one;
                    }

                }
            }
            max = Math.max(cur, max);
        }
        return max;
    }

    static class TreeNode {
        TreeNode zero;
        TreeNode one;
    }


    public static void main(String[] args) {
        int[] nums;
        nums = new int[]{3, 10, 5, 25, 2, 8};
        System.out.println(findMaximumXOR(nums) == 28);
    }
}
