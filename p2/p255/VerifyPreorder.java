package leetcode.p2.p255;

import java.util.Arrays;
import java.util.Stack;

public class VerifyPreorder {
    /**
     * Apr 11, 2024 23:07
     * Recursion
     * Time Complexity: O(nlogn)
     * Space Complexity: O(nlogn)
     */
    public boolean verifyPreorder1(int[] preorder) {
        int index = preorder.length;
        boolean check = false;
        for (int i = 1; i < preorder.length; i++) {
            if (!check && preorder[i] > preorder[0]) {
                index = i;
                check = true;
            }
            if (check) {
                if (preorder[i] < preorder[0]) {
                    return false;
                }
            }
        }

        if (index > 1) {
            int[] left = Arrays.copyOfRange(preorder, 1, index);
            if (!verifyPreorder1(left)) {
                return false;
            }
        }
        if (index < preorder.length) {
            int[] right = Arrays.copyOfRange(preorder, index, preorder.length);
            if (!verifyPreorder1(right)) {
                return false;
            }
        }
        return true;
    }


    public boolean verifyPreorder(int[] preorder) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < preorder.length; i++) {
            if (stack.isEmpty()) {
                stack.push(preorder[i]);
            } else {
                if (preorder[i] < stack.peek()) {
                    
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        VerifyPreorder v = new VerifyPreorder();
        int[] preorder;

        preorder = new int[]{1, 3, 4, 2};
        System.out.println(!v.verifyPreorder(preorder));
    }
}
