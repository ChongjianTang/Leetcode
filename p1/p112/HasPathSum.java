package leetcode.p1.p112;

import com.sun.source.tree.Tree;

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

public class HasPathSum {
    /**
     * Recursion
     */
    public boolean hasPathSum1(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }
        return hasPathSum1(root.left, targetSum - root.val) || hasPathSum1(root.right, targetSum - root.val);
    }

    /**
     * Iteration
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> sumStack = new Stack<>();
        nodeStack.push(root);
        sumStack.push(targetSum);
        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            int target = sumStack.pop();
            if (node.left == null && node.right == null && target == node.val) {
                return true;
            }
            if (node.left != null) {
                nodeStack.push(node.left);
                sumStack.push(target - node.val);
            }
            if (node.right != null) {
                nodeStack.push(node.right);
                sumStack.push(target - node.val);
            }
        }
        return false;
    }
}
