package leetcode.p0.p94;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class InorderTraversal {
    /**
     * Recursion
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper1(root, result);
        return result;
    }

    public void helper1(TreeNode root, List<Integer> result) {
        if (root != null) {
            helper1(root.left, result);
            result.add(root.val);
            helper1(root.right, result);
        }
    }

    /**
     * Iteration with stack
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode ptr = root;
        while (!stack.isEmpty() || ptr != null) {
            while (ptr != null) {
                stack.push(ptr);
                ptr = ptr.left;
            }
            ptr = stack.pop();
            result.add(ptr.val);
            ptr = ptr.right;
        }
        return result;
    }
}
