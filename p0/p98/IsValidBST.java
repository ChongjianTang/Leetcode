package leetcode.p0.p98;


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

public class IsValidBST {
    /**
     * Classic one
     * It reminds me of the days of CS61B
     */
    public boolean isValidBST(TreeNode root) {
        return dfs1(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean dfs1(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        if (root.val > min && root.val < max) {
            return dfs1(root.left, min, root.val) && dfs1(root.right, root.val, max);
        }
        return false;
    }
}
