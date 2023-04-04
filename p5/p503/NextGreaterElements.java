package leetcode.p5.p503;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class NextGreaterElements {
    /**
     * My approach
     * Monotonic stack
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public static int[] nextGreaterElements1(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums.length];
        int i = 0;
        int count = 0;
        while (count < 2 * nums.length) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                result[stack.pop()] = nums[i];
            }
            if (count < nums.length) {
                stack.push(i);
            }
            i++;
            if (i == nums.length) {
                i = 0;
            }
            count++;
        }
        while (!stack.isEmpty()) {
            result[stack.pop()] = -1;
        }
        return result;
    }

    /**
     * Solution
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public static int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 2 * nums.length - 1; i >= 0; --i) {
            while (!stack.empty() && nums[stack.peek()] <= nums[i % nums.length]) {
                stack.pop();
            }
            res[i % nums.length] = stack.empty() ? -1 : nums[stack.peek()];
            stack.push(i % nums.length);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElements1(new int[]{1, 2, 3, 4, 3})));
    }
}
