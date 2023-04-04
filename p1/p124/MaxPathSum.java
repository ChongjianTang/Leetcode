package leetcode.p1.p124;

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

public class MaxPathSum {
    static int max;

    /**
     * Recursion
     * Time complexity: O(N), where n is number of nodes
     * Space complexity: O(H), where H is a tree height
     */
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        max = Integer.MIN_VALUE;
        maxBranchSum(root);
        return max;
    }

    /**
     * Sum of nodes that end at root
     */
    public int maxBranchSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftBranchSum = maxBranchSum(root.left);
        int rightBranchSum = maxBranchSum(root.right);
        int result = root.val;
        if (leftBranchSum > 0) {
            result += leftBranchSum;
        }
        if (rightBranchSum > 0) {
            result += rightBranchSum;
        }
        if (result > max) {
            max = result;
        }
        return Math.max(root.val, Math.max(leftBranchSum + root.val, rightBranchSum + root.val));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
    }
}
