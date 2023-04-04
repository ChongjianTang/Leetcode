package leetcode.p0.p42;

import java.util.Stack;

/**
 * n == height.length
 * 1 <= n <= 2 * 10^4
 * 0 <= height[i] <= 10^5
 */
public class Trap {
    /**
     * My method
     * Actually it is two pointers!!!
     */
    public static int trap1(int[] height) {
        int result = 0;
        int maxIndex = 0;
        /*
        Get the index of the max number.
         */
        for (int i = 1; i < height.length; i++) {
            if (height[i] > height[maxIndex]) {
                maxIndex = i;
            }
        }

        for (int i = 0; i < maxIndex; i++) {
            int water = 0;
            for (int j = i + 1; j <= maxIndex; j++) {
                if (height[j] < height[i]) {
                    water += height[i] - height[j];
                } else {
                    result += water;
                    i = j - 1;
                    break;
                }
            }
        }

        for (int i = height.length - 1; i > maxIndex; i--) {
            int water = 0;
            for (int j = i - 1; j >= maxIndex; j--) {
                if (height[j] < height[i]) {
                    water += height[i] - height[j];
                } else {
                    result += water;
                    i = j + 1;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * Brute Force
     * TLE
     * Time complexity: O(n^2)
     * Space complexity: O(1)
     */
    public static int trap2(int[] height) {
        int result = 0;
        for (int i = 0; i < height.length; i++) {
            int maxLeftHeight = height[i];
            int maxRightHeight = height[i];
            for (int j = i; j >= 0; j--) {
                if (maxLeftHeight < height[j]) {
                    maxLeftHeight = height[j];
                }
            }
            for (int j = i; j < height.length; j++) {
                if (maxRightHeight < height[j]) {
                    maxRightHeight = height[j];
                }
            }
            result += Math.min(maxLeftHeight, maxRightHeight) - height[i];
        }
        return result;
    }

    /**
     * DP
     * Time complexity: O(n) 3n
     * Space complexity: O(n)
     */
    public static int trap3(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        left[0] = height[0];
        right[height.length - 1] = height[height.length - 1];
        for (int i = 1; i < left.length; i++) {
            left[i] = Math.max(height[i], left[i - 1]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            right[i] = Math.max(height[i], right[i + 1]);
        }
        int result = 0;
        for (int i = 0; i < height.length; i++) {
            result += Math.min(right[i], left[i]) - height[i];
        }
        return result;
    }

    /**
     * Using monotonic stacks
     * This is a good idea
     * Time O(n)
     * Space O(n)
     */
    public static int trap4(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.empty() && height[i] > height[stack.peek()]) {
                int index = stack.pop();
                if (stack.empty()) {
                    break;
                }
                result += (i - stack.peek() - 1) * (Math.min(height[i], height[stack.peek()]) - height[index]);
            }
            stack.push(i);
        }
        return result;
    }

    /**
     * Using two pointers
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public static int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int result = 0;
        while (left < right) {
            if (height[left] <= height[right]) {
                int index = left + 1;
                while (height[left] > height[index]) {
                    result += height[left] - height[index];
                    index++;
                }
                left = index;
            } else {
                int index = right - 1;
                while (height[right] > height[index]) {
                    result += height[right] - height[index];
                    index--;
                }
                right = index;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(trap4(new int[]{3, 2, 1, 2, 3}) == 4);
        System.out.println(trap(new int[]{4, 2, 3}) == 1);
        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}) == 6);
        System.out.println(trap(new int[]{4, 2, 0, 3, 2, 5}) == 9);

    }
}
