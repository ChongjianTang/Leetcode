package leetcode.p1.p145;

import com.sun.source.tree.Tree;

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

public class PostorderTraversal {
    /**
     * Recursion
     */
    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper1(root, result);
        return result;
    }

    public void helper1(TreeNode root, List<Integer> result) {
        if (root != null) {
            helper1(root.left, result);
            helper1(root.right, result);
            result.add(root.val);
        }
    }

    /**
     * Iteration
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode ptr = root;
        TreeNode rightChild = null;
        while (ptr != null || !stack.isEmpty()) {
            while (ptr != null) {
                result.add(ptr.val);
                stack.push(ptr);
                ptr = ptr.left;
            }
            ptr = stack.pop();
            if (ptr.right == null || ptr.right == rightChild) {
                result.add(ptr.val);
                rightChild = ptr;
                ptr = null;
            } else {
                stack.push(ptr);
                ptr = ptr.right;
            }
        }
        return result;
    }
}
