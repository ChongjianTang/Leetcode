package leetcode.p9.p938;

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

public class RangeSumBST {
    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        int result = 0;
        if (root.val >= low && root.val <= high) {
            result += root.val;
        }
        if (root.val > low) {
            result += rangeSumBST(root.left, low, high);
        }
        if (root.val < high) {
            result += rangeSumBST(root.right, low, high);
        }
        return result;
    }
}
