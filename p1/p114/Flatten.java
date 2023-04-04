package leetcode.p1.p114;


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

public class Flatten {
    /**
     * My approach
     * Time complexity: O(n)
     * Space complexity: O(n), which is occupied by the recursion stack
     */
    public void flatten1(TreeNode root) {
        if (root != null) {
            helper1(root);
        }
    }

    public TreeNode helper1(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root;
        } else if (root.left == null) {
            return helper1(root.right);
        } else if (root.right == null) {
            root.right = root.left;
            root.left = null;
            return helper1(root.right);
        } else {
            TreeNode temp = helper1(root.left);
            temp.right = root.right;
            root.right = root.left;
            root.left = null;
            return helper1(temp.right);
        }
    }

    /**
     * Iterative Solution using Stack
     */
    public void flatten(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode ptr = root;
        // TODO need to implement
    }
}
