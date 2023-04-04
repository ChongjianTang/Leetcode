package leetcode.p6.p669;

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

public class TrimBST {
    /**
     * My approach
     * Time complexity: O(n) n is the number of nodes in the given tree.
     * Space complexity: O(n)
     */
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        TreeNode result;
        if (root.val >= low && root.val <= high) {
            result = root;

            if (root.val > low) {
                result.left = trimBST(root.left, low,high);
            } else {
                result.left = null;
            }
            if (root.val <high) {
                result.right = trimBST(root.right,low,high);
            } else {
                result.right = null;
            }

        } else if (root.val <low) {
            result = trimBST(root.right,low,high);
        } else {
            result = trimBST(root.left,low,high);
        }
        return result;
    }
}
