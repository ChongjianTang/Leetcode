package leetcode.p0.p84;

import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleArea {

    /**
     * Brute Force
     * Time complexity -- O(n^2)
     * TLE (90/98)
     */
    public static int largestRectangleArea1(int[] heights) {
        int result = 0;
        for (int i = 0; i < heights.length; i++) {
            int minValue = heights[i];
            for (int j = i; j < heights.length; j++) {
                if (heights[j] < minValue) {
                    minValue = heights[j];
                }
                int newArea = minValue * (j - i + 1);
                if (newArea > result) {
                    result = newArea;
                }
            }
        }
        return result;
    }


    /**
     * My method
     * Time complexity: O(n) actually it is O(3n)
     * Space complexity: O(n)
     * The basic idea is monotonic stack, and came from the problem 42
     * To find the largest bar which are smaller than it on both side.
     * 327ms
     * It is still too slow.
     */
    public static int largestRectangleArea2(int[] heights) {
        int[] rightMin = new int[heights.length];
        int[] leftMin = new int[heights.length];

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        rightMin[0] = -1;
        for (int i = 1; i < heights.length; i++) {
            while (!stack.empty() && heights[i] <= heights[stack.peek()]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                rightMin[i] = -1;
            } else {
                rightMin[i] = stack.peek();
            }
            stack.push(i);
        }

        stack.clear();
        stack.push(heights.length - 1);
        leftMin[heights.length - 1] = heights.length;
        for (int i = heights.length - 2; i >= 0; i--) {
            while (!stack.empty() && heights[i] <= heights[stack.peek()]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                leftMin[i] = heights.length;
            } else {
                leftMin[i] = stack.peek();
            }
            stack.push(i);
        }

        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int area = (leftMin[i] - rightMin[i] - 1) * heights[i];
            if (area > max) {
                max = area;
            }
        }
        return max;
    }

    /**
     * My approach
     * Monotonic stack
     * Around 190ms
     */
    public static int largestRectangleArea3(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        stack.push(0);
        int max = 0;
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] <= heights[stack.peek()]) {
                while (stack.size() > 1 && heights[i] < heights[stack.peek()]) {
                    int index = stack.pop();
                    int distance = i - stack.peek() - 1;
                    int area = distance * heights[index];
                    max = Math.max(area, max);
                }
            }
            stack.push(i);
        }
        while (stack.size() > 1) {
            int index = stack.pop();
            int distance = heights.length - stack.peek() - 1;
            int area = distance * heights[index];
            max = Math.max(area, max);
        }
        return max;
    }

    /**
     * Approach from zhitongguigu
     * Monotonic stack
     * Around 160ms
     */
    public static int largestRectangleArea(int[] heights) {
        int area = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            if (stack.isEmpty() || heights[stack.peek()] < heights[i]) {
                stack.push(i);
            } else {
                int start = stack.pop();
                int width;
                if (stack.isEmpty()) {
                    width = i;
                } else {
                    width = i - stack.peek() - 1;
                }
                area = Math.max(area, heights[start] * width);
                i--;
            }
        }
        while (!stack.isEmpty()) {
            int start = stack.pop();
            int width = stack.isEmpty() ? heights.length : heights.length - stack.peek() - 1;
            area = Math.max(area, heights[start] * width);
        }
        return area;
    }


    public static void main(String[] args) {
        int[] heights;
        int output;

        heights = new int[]{2, 1, 5, 6, 2, 3};
        output = 10;
        System.out.println(largestRectangleArea(heights) == output);

        heights = new int[]{2, 4};
        output = 4;
        System.out.println(largestRectangleArea(heights) == output);

        heights = new int[]{1, 1};
        output = 2;
        System.out.println(largestRectangleArea(heights) == output);
    }
}
