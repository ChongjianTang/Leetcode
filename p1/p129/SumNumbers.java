package leetcode.p1.p129;

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

public class SumNumbers {
    /**
     * Jan 11, 2023 15:00
     */
    public int sumNumbers(TreeNode root) {
        return backtracking1(root, 0);
    }

    public int backtracking1(TreeNode root, int cur) {
        cur = cur * 10 + root.val;
        int sum = 0;
        if (root.left == null && root.right == null) {
            return cur;
        }
        if (root.left != null) {
            sum += backtracking1(root.left, cur);
        }
        if (root.right != null) {
            sum += backtracking1(root.right, cur);
        }
        return sum;
    }
}
