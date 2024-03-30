package leetcode.p0.p85;

import java.util.Stack;

public class MaximalRectangle {
    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            while (stack.size() > 1 && heights[i] < heights[stack.peek()]) {
                int index = stack.pop();
                max = Math.max(max, (i - stack.peek() - 1) * heights[index]);
            }
            if (heights[i] == 0) {
                stack.clear();
            }
            stack.push(i);
        }
        while (stack.size() > 1) {
            int index = stack.pop();
            max = Math.max(max, (heights.length - stack.peek() - 1) * heights[index]);
        }
        return max;
    }

    /**
     * Mar 05, 2024 14:48
     * The idea is from question 84
     * Time Complexity: O(n*m)
     * Space Complexity: O(n)
     */
    public int maximalRectangle1(char[][] matrix) {
        int[] previous = new int[matrix[0].length];
        int maxRectangle = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < previous.length; j++) {
                if (matrix[i][j] == '1') {
                    previous[j]++;
                } else {
                    previous[j] = 0;
                }
            }
            maxRectangle = Math.max(maxRectangle, largestRectangleArea(previous));
        }
        return maxRectangle;
    }

    public int maximalRectangle(char[][] matrix) {
        // TODO
        return 0;
    }


    public static void main(String[] args) {
        MaximalRectangle m = new MaximalRectangle();
        char[][] matrix;
        int expected;

        matrix = new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };

        expected = 6;
        System.out.println(m.maximalRectangle(matrix) == expected);
    }
}
