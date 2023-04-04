package leetcode.p1.p144;

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

public class PreorderTraversal {
    /**
     * Recursion
     */
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper1(root, result);
        return result;
    }

    public void helper1(TreeNode root, List<Integer> result) {
        if (root != null) {
            result.add(root.val);
            helper1(root.left, result);
            helper1(root.right, result);
        }
    }

    /**
     * Iteration with stack
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode ptr = root;
        while (ptr != null || !stack.isEmpty()) {
            while (ptr != null) {
                result.add(ptr.val);
                stack.push(ptr);
                ptr = ptr.left;
            }
            ptr = stack.pop();
            ptr = ptr.right;
        }
        return result;
    }
}
