package leetcode.p4.p404;

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

public class SumOfLeftLeaves {
    /**
     * Apr 16, 2024 23:50
     * Time Complexity: O(node.size)
     * Space Complexity: O(node.size)
     */
    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        if (root.left != null) {
            TreeNode leftChild = root.left;
            if (leftChild.left == null && leftChild.right == null) {
                sum += leftChild.val;
            } else {
                sum += sumOfLeftLeaves(leftChild);
            }
        }

        if (root.right != null) {
            sum += sumOfLeftLeaves(root.right);
        }
        return sum;
    }
}
