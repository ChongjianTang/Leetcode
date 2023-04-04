package leetcode.p17.p1762;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class FindBuildings {
    /**
     * My method
     * 6ms
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public static int[] findBuildings1(int[] heights) {
        List<Integer> result = new ArrayList<>();
        int max = 0;
        for (int i = heights.length - 1; i >= 0; i--) {
            if (heights[i] > max) {
                result.add(i);
                max = heights[i];
            }
        }
        int[] buildingsWithAnOceanView = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            buildingsWithAnOceanView[i] = result.get(result.size() - 1 - i);
        }
        return buildingsWithAnOceanView;
    }

    /**
     * Monotonic Stack
     * 36ms
     * slower than previous one(which is around 6ms)
     */
    public static int[] findBuildings(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(heights.length - 1);
        for (int i = heights.length - 2; i >= 0; i--) {
            if (heights[i] > heights[stack.peek()]) {
                stack.push(i);
            }
        }
        int[] result = new int[stack.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = stack.pop();
        }
        return result;
    }


    public static void main(String[] args) {
        int[] heights;
        int[] output;

        heights = new int[]{4, 2, 3, 1};
        output = new int[]{0, 2, 3};
        System.out.println(Arrays.equals(findBuildings(heights), output));

        heights = new int[]{4, 3, 2, 1};
        output = new int[]{0, 1, 2, 3};
        System.out.println(Arrays.equals(findBuildings(heights), output));

        heights = new int[]{1, 3, 2, 4};
        output = new int[]{3};
        System.out.println(Arrays.equals(findBuildings(heights), output));
    }
}
